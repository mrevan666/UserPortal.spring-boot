package com.admin.Admin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Occupation {

    @Id
    @Column(name = "Occupation_ID")
    private Integer id;

    @Column(name = "Occupation_Name")
    private String name;

    @Column(name = "Occupation_Description")
    private String description;


    public Occupation() {
    }

    public Occupation(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "occupations")
    List<User> users;

}
