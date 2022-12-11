package com.example.myspringproject.repository;

import com.example.myspringproject.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);
}
