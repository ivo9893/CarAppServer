package com.example.RESTController;

import com.example.Entity.User;
import com.example.Service.CreateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreateDataController {

    @Autowired
    CreateDataService createDataService;

    @PostMapping(value = "/createadd")
    public void createAdd(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
        createDataService.createAdd(payload);
    }
}
