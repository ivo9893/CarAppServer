package com.example.Entity;

import javax.persistence.*;

@Entity(name = "Cities")
@Table(name = "Cities")
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="City_ID")
    private String id;

    @Column(name="City_Name")
    private String name;

    public Cities(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cities(){

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
