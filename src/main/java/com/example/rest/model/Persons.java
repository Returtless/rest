package com.example.rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Persons{
    @EmbeddedId
    private MainInfo mainInfo;
    private String phone_number;
    private String city_of_living;
}

