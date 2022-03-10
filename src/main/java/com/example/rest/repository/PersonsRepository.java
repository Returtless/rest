package com.example.rest.repository;

import com.example.rest.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Integer> {


    List<Persons> findByCityIgnoreCase(String city);

    List<Persons> findByMainInfoAgeLessThanOrderByMainInfoAgeAsc(int age);

    Optional<Persons> findByMainInfoNameAndMainInfoSurname(String name, String surname);
}