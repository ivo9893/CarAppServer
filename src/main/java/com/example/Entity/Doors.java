package com.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Doors")
public class Doors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Door_ID")
    private String id;

    @Column(name="Door_Name")
    private String name;

    public Doors(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Doors(){

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
