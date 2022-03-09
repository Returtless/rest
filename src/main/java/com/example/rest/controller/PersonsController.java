package com.example.rest.controller;

import com.example.rest.model.Persons;
import com.example.rest.service.PersonsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PersonsController {
    PersonsService service;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) throws Exception {
        return service.getPersonsByCity(city);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidObjectException.class)
    private String resolveException(InvalidObjectException exception) {
        return exception.getMessage();
    }
}