package controllers;

import entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.DriverRepository;
import services.DriverService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController("driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    DriverService driverService = new DriverService(driverRepository);

    @PostMapping("/create")
    public ResponseEntity<HashMap<String, Object>> save(Driver driver) {
        return driverService.saveDriver(driver);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Driver>> getAll() {
        List<Driver> drivers = this.driverService.findAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }
}
