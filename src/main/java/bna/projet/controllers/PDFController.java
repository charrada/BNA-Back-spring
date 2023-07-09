package bna.projet.controllers;

import bna.projet.Repository.OperationRepository;
import bna.projet.Services.OperationService;
import bna.projet.entities.Operation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pdf")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PDFController {

    @Autowired
    OperationRepository operationRepository;
    @Autowired

    OperationService operationService;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> exportDataToPDF(@PathVariable Long id) {
        try {
            // Fetch data from the database
            Optional<Operation> operationOptional = operationRepository.findById(id);
            if (operationOptional.isEmpty()) {
                // Handle the case where the operation is not found
                return ResponseEntity.notFound().build();
            }
            Operation operation = operationOptional.get();

            // Create a new PDF document
            PDDocument document = new PDDocument();

            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a content stream for writing to the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            // Set the font for table content
            contentStream.setFont(PDType1Font.HELVETICA, 10);

            // Define table parameters
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
            float yPosition = yStart;
            float bottomMargin = 70;
            float tableRowHeight = 20;
            float tableCellMargin = 5;

            // Define table headers
            String[] tableHeaders = {"ID", "Montant", "Type Operation", "Etat Operation"};

            // Define table content
            String[][] data = {
                    {String.valueOf(operation.getIdOperation()), String.valueOf(operation.getMontant()), operation.getTypeOperation(), operation.getEtatOperation()}
                    // Add more rows as needed
            };

            // Draw table headers
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText(tableHeaders[0]);
            contentStream.newLineAtOffset(tableWidth / 4, 0);
            contentStream.showText(tableHeaders[1]);
            contentStream.newLineAtOffset(tableWidth / 4, 0);
            contentStream.showText(tableHeaders[2]);
            contentStream.newLineAtOffset(tableWidth / 4, 0);
            contentStream.showText(tableHeaders[3]);
            contentStream.endText();

            // Draw table rows
            yPosition -= tableRowHeight;
            for (String[] row : data) {
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                for (int i = 0; i < row.length; i++) {
                    contentStream.showText(row[i]);
                    contentStream.newLineAtOffset(tableWidth / 4, 0);
                }
                contentStream.endText();
                yPosition -= tableRowHeight;
            }

            // Close the content stream
            contentStream.close();

            // Save the PDF to a byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            // Set the appropriate headers for the response
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentDispositionFormData("attachment", "data.pdf");

            // Return the PDF byte array as the response body
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        // Return an error response if something goes wrong
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
