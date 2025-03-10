package com.example.code_challenge4.services;

import com.example.code_challenge4.dto.DriverDto;
import com.example.code_challenge4.entities.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import com.example.code_challenge4.repositories.DriverRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
@Setter
public class DriverService {

    private final DriverRepository driverRepository;


    public DriverDto saveDriver(String name, Integer age) {

        Optional<Driver> optionalDriver = driverRepository.findByName(name);
        if (optionalDriver.isPresent()) {
            return null;
        }

        Driver driver = new Driver();
        driver.setName(name);
        driver.setAge(age);

        Driver savedDriver = driverRepository.save(driver);
        return new DriverDto(savedDriver);

    }

    public List<DriverDto> findAll() {
        Iterable<Driver> drivers = this.driverRepository.findAll();
        List<DriverDto> driverDtos = new ArrayList<>();
        for (Driver driver : drivers) {
            DriverDto driverDto = new DriverDto(driver);
            driverDtos.add(driverDto);
        }
        return driverDtos;


    }
}
