package services;

import entities.Driver;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import repositories.DriverRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DriverService {

    DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public ResponseEntity<HashMap<String, Object>> saveDriver(Driver driver) {
        HashMap<String, Object> body = new HashMap<>();
        Driver d = this.driverRepository.save(driver);
        body.put("message", "Driver saved");
        body.put("driver", d.getId());

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public List<Driver> findAll() {
        Iterable<Driver> drivers = this.driverRepository.findAll();
        List<Driver> driverList = new ArrayList<>();
        for (Driver d : drivers) {
            driverList.add(d);
        }
        return driverList;
    }
}
