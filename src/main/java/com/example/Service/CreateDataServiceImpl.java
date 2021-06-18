package com.example.Service;

import com.example.DAO.CreateDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CreateDataServiceImpl implements CreateDataService{

    @Autowired
    CreateDataDAO createDataDAO;

    @Override
    @Transactional
    public void createAdd(com.fasterxml.jackson.databind.JsonNode payload) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        UUID uuid = UUID.randomUUID();
        createDataDAO.createCarAd(payload.get("Brand").asInt(), payload.get("Model").asInt(), payload.get("Price").asDouble(),
                payload.get("Date").asText(), payload.get("Specification").asText(), payload.get("Engine").asInt(),
                payload.get("GearBox").asInt(), payload.get("HorsePower").asInt(), payload.get("Mileage").asInt(),
                payload.get("Doors").asInt(), payload.get("Coupe").asInt(), payload.get("Color").asInt(), payload.get("City").asInt(),
                payload.get("Description").asText(), dtf.format(now), payload.get("userID").asInt(), uuid.toString(), payload.get("ImageName"),
                payload.get("main_image").asText()
                );
    }
}
