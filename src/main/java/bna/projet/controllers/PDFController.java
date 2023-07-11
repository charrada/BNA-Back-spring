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
import java.util.Optional;

@RestController
@RequestMapping("pdf")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PDFController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationService operationService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> exportDataToPDF(@PathVariable Long id) {
        Optional<Operation> operationOptional = operationRepository.findById(id);
        if (operationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Operation operation = operationOptional.get();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA, 10);

            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
            float yPosition = yStart;
            float bottomMargin = 70;
            float tableRowHeight = 20;
            float tableCellMargin = 5;

            String[] tableHeaders = {"ID", "Montant", "Type Operation", "Etat Operation"};

            String[][] data = {
                    {String.valueOf(operation.getIdOperation()), String.valueOf(operation.getMontant()), operation.getTypeOperation(), operation.getEtatOperation()}
            };

            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            for (String header : tableHeaders) {
                contentStream.showText(header);
                contentStream.newLineAtOffset(tableWidth / 4, 0);
            }
            contentStream.endText();

            yPosition -= tableRowHeight;
            for (String[] row : data) {
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                for (String cell : row) {
                    contentStream.showText(cell);
                    contentStream.newLineAtOffset(tableWidth / 4, 0);
                }
                contentStream.endText();
                yPosition -= tableRowHeight;
            }

            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentDispositionFormData("attachment", "operation.pdf");

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
