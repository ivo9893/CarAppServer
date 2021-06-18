package com.example.DAO;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface CreateDataDAO {

//    @Modifying
//    @Query("  insert into CarAd(brand, model, price, date, specification, engine, gearbox, hp, mileage, doors, coupe, color, city, description, date_created, userID)\n" +
//            "  Values(:brand, :model, :price, :date, :specification, :engine, :gearbox, :hp, :mileage, :doors, :coupe, :color, :city, :description, :date_created, :userID) ")
//    void createCarAd(@Param("brand") int brand, @Param("model") int model, @Param("price") double price, @Param("date") String date,
//                     @Param("specification") String specification, @Param("engine") int engine, @Param("gearbox") int gearbox,
//                     @Param("hp") int hp, @Param("mileage") int mileage, @Param("doors") int doors, @Param("coupe") int coupe,
//                     @Param("color") int color, @Param("city") int city, @Param("description") String description, @Param("date_created") String date_created,
//                     @Param("userID") int userID
//                     );

    void createCarAd(int brand, int model, double price, String date, String specification, int engine, int gearbox, int hp, int mileage, int doors, int coupe, int color, int city, String description, String date_created, int userID, String rowID, JsonNode imageName, String main_image);

}
