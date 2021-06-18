package com.example.Service;

import com.example.Entity.Brands;
import com.example.Entity.Models;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ListsService {

    List<Brands> getAllBrands();
    List<Models> getAllModels();
    String getAllData() throws JsonProcessingException;
    void savePhoto(MultipartFile imageFile) throws IOException;
}
