package com.example.Entity;

import javax.persistence.*;

@Entity
@Table(name="Color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Color_ID")
    private String id;

    @Column(name="Color_Name")
    private String name;

    public Color(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Color(){

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
