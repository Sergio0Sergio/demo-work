package com.example.demo.controller;

import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() {
        try {
            return imageService.getImage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
