package com.example.code_challenge4.repositories;

import com.example.code_challenge4.entities.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriverRepository extends CrudRepository<Driver, Integer> {

    Optional<Driver> findByName(String name);
}
