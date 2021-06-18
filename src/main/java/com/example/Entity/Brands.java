package com.example.Entity;

import javax.persistence.*;

@Entity(name = "Brand")
@Table(name="Brand")
public class Brands {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Brand_id")
    private String id;

    @Column(name="Brand_Name")
    private String name;

    public Brands(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brands(){

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
