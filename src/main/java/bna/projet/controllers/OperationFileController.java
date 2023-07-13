package bna.projet.controllers;

import bna.projet.Repository.OperationFileRepository;
import bna.projet.entities.OperationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("image")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OperationFileController {

    @Autowired
    OperationFileRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<OperationFile> uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("idOperation") Long idOperation) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        OperationFile img = new OperationFile();
        img.setName(file.getOriginalFilename());
        img.setType(file.getContentType());
        img.setPicByte(compressBytes(file.getBytes()));
        img.setIdOperation(idOperation); // Set the idOperation field
        imageRepository.save(img);
        return ResponseEntity.ok(img);
    }

    @GetMapping(path = { "/get/{idOperation}" })
    public ResponseEntity<OperationFile> getImageByOperationId(@PathVariable("idOperation") Long idOperation) throws IOException {
        final Optional<OperationFile> retrievedImage = imageRepository.findByIdOperation(idOperation);
        if (retrievedImage.isPresent()) {
            OperationFile img = retrievedImage.get();
            img.setPicByte(decompressBytes(img.getPicByte())); // Decompress the image bytes
            return ResponseEntity.ok(img);
        } else {
            throw new IOException("Image not found for operation ID: " + idOperation);
        }
    }

    @GetMapping(path = { "/getT/{idOperation}" })
    public ResponseEntity<String> getTextContentByOperationId(@PathVariable("idOperation") Long idOperation) throws IOException {
        final Optional<OperationFile> retrievedImage = imageRepository.findByIdOperation(idOperation);
        if (retrievedImage.isPresent()) {
            OperationFile img = retrievedImage.get();
            if (img.getType().equals("text/plain")) {
                String textContent = new String(decompressBytes(img.getPicByte()));
                return ResponseEntity.ok(textContent);
            } else {
                throw new IOException("File is not a text file");
            }
        } else {
            throw new IOException("Image not found for operation ID: " + idOperation);
        }
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
