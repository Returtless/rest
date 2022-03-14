package com.example.rest.controller;

import com.example.rest.model.Persons;
import com.example.rest.service.PersonsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.io.InvalidObjectException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PersonsController {
    PersonsService service;

    @PreAuthorize("hasAnyRole('DELETE')")
    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) throws Exception {
        return service.getPersonsByCity(city);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/persons/by-age")
    public List<Persons> getPersonsByCity(@RequestParam("age") int age) throws Exception {
        return service.getPersonsByAge(age);
    }

    @Secured("ROLE_READ")
    @GetMapping("/persons/by-name-surname")
    public Persons getPersonsByCity(@RequestParam("name") String name, @RequestParam("surname") String surname) throws Exception {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/admin")
    public String admin(String username) throws Exception {
        return "YOU ARE ADMIN!";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidObjectException.class)
    private String resolveException(InvalidObjectException exception) {
        return exception.getMessage();
    }
}