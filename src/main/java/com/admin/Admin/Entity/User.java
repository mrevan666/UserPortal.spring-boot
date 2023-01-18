package com.admin.Admin.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "UserID")
    @Positive(message = "Id must be positive number")
    @NotNull(message = "Please fill this zone")
    private int id;

    @Column(name = "Name")
    @NotBlank(message = "Please fill this zone")
    @Size(min = 3,max = 30,message = "Name must be more than three characters")
    private String name;

    @Column(name = "Surname")
    @NotBlank(message = "Please fill this zone")
    @Size(min = 3,max = 30,message = "Surname must be more than three characters")
    private String surname;

    @ManyToMany
    @JoinTable(name = "Users_Occupations",
            joinColumns = @JoinColumn(name = "User_ID"),
            inverseJoinColumns = @JoinColumn(name = "Occupation_ID"))
    List<Occupation> occupations;

    public User() {
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public List<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }
}
