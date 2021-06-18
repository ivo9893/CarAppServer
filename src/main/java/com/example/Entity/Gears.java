package com.example.Entity;


import javax.persistence.*;

@Entity
@Table(name="Gears")
public class Gears {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Gear_ID")
    private String id;

    @Column(name="Gear_Name")
    private String name;

    public Gears(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Gears(){

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
