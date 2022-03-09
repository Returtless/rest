package com.example.rest.repository;

import com.example.rest.model.Persons;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("Select p from Persons p where upper(p.city_of_living) = upper(:city)", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}