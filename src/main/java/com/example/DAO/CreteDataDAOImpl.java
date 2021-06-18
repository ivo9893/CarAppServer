package com.example.DAO;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CreteDataDAOImpl implements CreateDataDAO{

    @Autowired
    EntityManager entityManager;


    @Override
    public void createCarAd(int brand, int model, double price, String date, String specification, int engine, int gearbox, int hp, int mileage, int doors, int coupe, int color, int city, String description, String date_created, int userID, String rowID, JsonNode imageName, String main_image) {
        entityManager.createNativeQuery("insert into CarAd(brand, model, price, date, specification, engine, gearbox, hp, mileage, doors, coupe, color, city, description, date_created, userID, row_id, main_image)\n" +
        "  Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")
                .setParameter(1, brand)
                .setParameter(2, model)
                .setParameter(3, price)
                .setParameter(4, date)
                .setParameter(5, specification)
                .setParameter(6, engine)
                .setParameter(7, gearbox)
                .setParameter(8, hp)
                .setParameter(9, mileage)
                .setParameter(10, doors)
                .setParameter(11, coupe)
                .setParameter(12, color)
                .setParameter(13, city)
                .setParameter(14, description)
                .setParameter(15, date_created)
                .setParameter(16, userID)
                .setParameter(17, rowID)
                .setParameter(18, main_image)
                .executeUpdate();

            if(imageName.isArray()){
                for(JsonNode node : imageName){
                    entityManager.createNativeQuery("INSERT INTO ImageNames VALUES(?,?)")
                            .setParameter(1, rowID)
                            .setParameter(2, node.toString())
                            .executeUpdate();
                }
            }
    }
}
