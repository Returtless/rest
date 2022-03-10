package com.example.rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Persons{
    @EmbeddedId
    private MainInfo mainInfo;
    private String phone_number;
    @Column(name = "city_of_living")
    private String city;
}

