package com.example.rest.controller;

import com.example.rest.exception.InvalidCredentials;
import com.example.rest.exception.UnauthorizedUser;
import com.example.rest.model.Authorities;
import com.example.rest.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    private String resolveInvalidCredentialsException(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    private String resolveUnauthorizedUserException(UnauthorizedUser exception) {
        return exception.getMessage();
    }
}