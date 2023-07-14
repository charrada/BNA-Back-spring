package bna.projet.controllers;

import bna.projet.Repository.AccountPDPRepository;
import bna.projet.Repository.OperationFileRepository;
import bna.projet.entities.AccountPDP;
import bna.projet.entities.OperationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("pdp")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountPDPController {

    @Autowired
    AccountPDPRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<AccountPDP> uploadPDP(@RequestParam("imageFile") MultipartFile file, @RequestParam("username") String username) {
        try {
            System.out.println("Original Image Byte Size - " + file.getBytes().length);
            AccountPDP img = new AccountPDP();
            img.setName(file.getOriginalFilename());
            img.setType(file.getContentType());
            img.setPicByte(compressBytes(file.getBytes()));
            img.setUsername(username); // Set the idOperation field
            imageRepository.save(img);
            return ResponseEntity.ok(img);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = { "/get/{username}" })
    public ResponseEntity<AccountPDP> getPDPByUsername(@PathVariable("username") String username) {
        final Optional<AccountPDP> retrievedImage = imageRepository.findByUsername(username);
        if (retrievedImage.isPresent()) {
            AccountPDP img = retrievedImage.get();
            img.setPicByte(decompressBytes(img.getPicByte())); // Decompress the image bytes
            return ResponseEntity.ok(img);
        } else {
            return ResponseEntity.notFound().build();
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
