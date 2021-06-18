package com.example.RESTController;


import com.example.Entity.Brands;
import com.example.Entity.Models;
import com.example.Service.ListsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/lists")
public class ListsController {

    @Autowired
    ListsService listsService;

    @GetMapping("/allBrands")
    public List<Brands> getAllBrands() {

        return listsService.getAllBrands();
    }

    @GetMapping("/allModels")
    public List<Models> getAllModels() {

        return listsService.getAllModels();
    }
    @GetMapping("/allData")
    public String getAllData() throws JsonProcessingException {

       return listsService.getAllData();

    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile")MultipartFile[] imageFile) throws IOException {

        String returnValue = "";
        for(MultipartFile file : imageFile)
            listsService.savePhoto(file);
        return returnValue;
    }

}
