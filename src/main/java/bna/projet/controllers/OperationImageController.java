package bna.projet.controllers;

import bna.projet.Repository.OperationImageRepository;
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
@RequestMapping("image")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OperationImageController {

    @Autowired
    OperationImageRepository imageRepository;
    @PostMapping("/upload")
    public ResponseEntity<OperationImage> uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("idOperation") Long idOperation) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        OperationImage img = new OperationImage();
        img.setName(file.getOriginalFilename());
        img.setType(file.getContentType());
        img.setPicByte(compressBytes(file.getBytes()));
        img.setIdOperation(idOperation); // Set the idOperation field
        imageRepository.save(img);
        return ResponseEntity.ok(img);
    }



    @GetMapping(path = { "/get/{imageName}" })
    public OperationImage getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<OperationImage> retrievedImage = imageRepository.findByName(imageName);
        if (retrievedImage.isPresent()) {
            OperationImage img = retrievedImage.get();
            img.setPicByte(decompressBytes(img.getPicByte())); // Decompress the image bytes
            return img;
        } else {
            throw new IOException("Image not found: " + imageName);
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
