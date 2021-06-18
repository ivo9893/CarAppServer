package com.example.Entity;

import org.springframework.data.web.config.EnableSpringDataWebSupport;

import javax.persistence.*;

@Entity(name = "Model")
@Table(name = "Model")
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Model_ID")
    private String id;

    @Column(name = "Model_Name")
    private String name;

    @Column(name = "Model_BrandID")
    private String brandId;

    public Models(String id, String name, String brandId) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
    }

    public Models(){

    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
