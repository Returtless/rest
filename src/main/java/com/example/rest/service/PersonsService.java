package com.example.rest.service;

import com.example.rest.model.Persons;
import com.example.rest.repository.PersonsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonsService {
    PersonsRepository personsRepository;

    public List<Persons> getPersonsByCity(String city) throws Exception {
        List<Persons> userAuthorities = personsRepository.getPersonsByCity(city);
        if (isEmpty(userAuthorities)) {
            throw new InvalidObjectException("Unknown city " + city);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}