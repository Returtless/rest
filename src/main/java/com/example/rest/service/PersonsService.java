package com.example.rest.service;

import com.example.rest.model.Persons;
import com.example.rest.repository.PersonsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonsService {
    PersonsRepository personsRepository;

    public List<Persons> getPersonsByCity(String city) throws Exception {
        List<Persons> persons = personsRepository.findByCityIgnoreCase(city);
        if (isEmpty(persons)) {
            throw new InvalidObjectException("Unknown city " + city);
        }
        return persons;
    }

    public List<Persons> getPersonsByAge(int age) throws Exception {
        List<Persons> persons = personsRepository.findByMainInfoAgeLessThanOrderByMainInfoAgeAsc(age);
        if (isEmpty(persons)) {
            throw new InvalidObjectException("Unknown age " + age);
        }
        return persons;
    }

    public Persons getPersonsByNameAndSurname(String name, String surname) throws Exception {
        Optional<Persons> persons = personsRepository.findByMainInfoNameAndMainInfoSurname(surname, name);
        if (persons.isEmpty()) {
            throw new InvalidObjectException("Unknown " + name + " and " + surname);
        }
        return persons.get();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}