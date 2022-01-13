package com.example.rest.repository;

import com.example.rest.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "admin".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.DELETE, Authorities.WRITE);
        }
        return new ArrayList<>();
    }
}