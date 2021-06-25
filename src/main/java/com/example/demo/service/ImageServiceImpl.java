package com.example.demo.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/california.jpg");
        return IOUtils.toByteArray(in);
    }
}
