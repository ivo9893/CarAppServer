package com.example.Service;

import com.example.DAO.ListsDAO;
import com.example.Entity.Brands;
import com.example.Entity.Models;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
public class ListServiceImpl implements ListsService{

    @Autowired
    private ListsDAO listsDAO;

    @Transactional
    @Override
    public List<Brands> getAllBrands() {
        return listsDAO.getAllBrands();
    }

    @Transactional
    @Override
    public List<Models> getAllModels() {
        return listsDAO.getAllModels();
    }

    @Transactional
    @Override
    public String getAllData() throws JsonProcessingException {
        return listsDAO.getAllData();

    }

    @Override
    public void savePhoto(MultipartFile imageFile) throws IOException {
        listsDAO.savePhoto(imageFile);
    }
}
