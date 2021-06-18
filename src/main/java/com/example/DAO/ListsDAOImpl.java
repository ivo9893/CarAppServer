package com.example.DAO;

import com.example.Entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.bytecode.ByteArray;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ListsDAOImpl implements ListsDAO{

    @Autowired
    private EntityManager entityManager;

    public ListsDAOImpl(){

    }

    @Override
    public List<Brands> getAllBrands() {
        Session session = entityManager.unwrap(Session.class);
        try{
            TypedQuery<Brands> query = session.createQuery(" from Brand", Brands.class);
            return query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Models> getAllModels() {
        Session session = entityManager.unwrap(Session.class);
        try{
            TypedQuery<Models> query = session.createQuery(" from Model", Models.class);
            return query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getAllData() throws JsonProcessingException {
        Map<String, List> map = new HashMap<String, List>();
        Session session = entityManager.unwrap(Session.class);

        TypedQuery<Models> modelQuery = session.createQuery(" from Model", Models.class);
        map.put("Models", modelQuery.getResultList());

        TypedQuery<Brands> brandQuery = session.createQuery(" from Brand", Brands.class);
        map.put("Brands", brandQuery.getResultList());

        TypedQuery<Cities> citiesQuery = session.createQuery(" from Cities", Cities.class);
        map.put("Cities", citiesQuery.getResultList());

        TypedQuery<Gears> gearsQuery = session.createQuery(" from Gears", Gears.class);
        map.put("Gears", gearsQuery.getResultList());

        TypedQuery<Coupe> coupeQuery = session.createQuery(" from Coupe", Coupe.class);
        map.put("Coupe", coupeQuery.getResultList());

        TypedQuery<Color> colorQuery = session.createQuery(" from Color", Color.class);
        map.put("Color", colorQuery.getResultList());

        TypedQuery<Doors> doorQuery = session.createQuery(" from Doors", Doors.class);
        map.put("Doors", doorQuery.getResultList());

        return new ObjectMapper().writeValueAsString(map);
    }

    @Override
    public void savePhoto(MultipartFile imageFile) throws IOException {
        String folder = "/photos/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
