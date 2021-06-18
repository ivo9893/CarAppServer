package com.example.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Coupe")
public class Coupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Coupe_ID")
    private String id;

    @Column(name="Coupe_Name")
    private String name;

    public Coupe(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Coupe(){

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
