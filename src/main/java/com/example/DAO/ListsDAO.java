package com.example.DAO;

import com.example.Entity.Brands;
import com.example.Entity.Models;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ListsDAO {

    List<Brands> getAllBrands();
    List<Models> getAllModels();
    void savePhoto(MultipartFile imageFile) throws IOException;
    String getAllData() throws JsonProcessingException;

}
