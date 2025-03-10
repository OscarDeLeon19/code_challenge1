package com.example.code_challenge4.controllers;

import com.example.code_challenge4.dto.DriverDto;
import com.example.code_challenge4.dto.DriverRequest;
import com.example.code_challenge4.entities.Driver;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.code_challenge4.services.DriverService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
@AllArgsConstructor
@Getter
@Setter
public class DriverController {

    private final DriverService driverService;

    @PostConstruct
    public void init() {
        System.out.println("DriverController cargado correctamente.");
    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> saveDriver(@RequestBody DriverRequest driver) {
        HashMap<String, Object> response = new HashMap<>();
        DriverDto driverDto = driverService.saveDriver(driver.getName(), driver.getAge());
        if(driverDto == null) {
            response.put("message", "El nombre del driver ya esta registrado");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("message", "El driver se ha registrado.");
        response.put("idDriver", driverDto.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        List<DriverDto> drivers = this.driverService.findAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }
}
