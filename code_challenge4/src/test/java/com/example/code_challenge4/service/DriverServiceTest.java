package com.example.code_challenge4.service;

import com.example.code_challenge4.dto.DriverDto;
import com.example.code_challenge4.dto.DriverRequest;
import com.example.code_challenge4.entities.Driver;
import com.example.code_challenge4.repositories.DriverRepository;
import com.example.code_challenge4.services.DriverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DriverServiceTest {

    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveDriverSuccesfully(){
        DriverRequest request = new DriverRequest("test name", 20);

        Driver driver = new Driver(1, request.getName(), request.getAge());
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver);

        DriverDto result = new DriverDto(driver);

        DriverDto actual = this.driverService.saveDriver(request.getName(), request.getAge());

        Assertions.assertEquals(result.getId(), actual.getId());
        Assertions.assertEquals(result.getName(), actual.getName());
        Assertions.assertEquals(result.getAge(), actual.getAge());
    }

    @Test
    public void saveDriverFails(){
        DriverRequest request = new DriverRequest("test name", 20);
        Driver driver = new Driver(1, request.getName(), request.getAge());

        when(driverRepository.findByName(driver.getName())).thenReturn(Optional.of(driver));

        DriverDto result = driverService.saveDriver(request.getName(), request.getAge());

        Assertions.assertNull(result);
    }

    @Test
    public void getAllDriversSuccesfully(){
        Driver driver1 = new Driver(1, "test name", 20);
        Driver driver2 = new Driver(2, "test name1", 5);
        Iterable<Driver> drivers = Arrays.asList(driver1, driver2);

        when(this.driverRepository.findAll()).thenReturn(drivers);

        DriverDto d1 = new DriverDto(driver1);
        DriverDto d2 = new DriverDto(driver2);
        List<DriverDto> expected = new ArrayList<>();
        expected.add(d1);
        expected.add(d2);

        List<DriverDto> result = this.driverService.findAll();

        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
        Assertions.assertEquals(expected.get(1).getName(), result.get(1).getName());

    }

    @Test
    public void updateDriverSuccesfully(){
        DriverRequest request = new DriverRequest("test name", 20);
        Driver driver = new Driver(1, request.getName(), request.getAge());
        Driver driverUpdate = new Driver(1, "update", request.getAge());

        when(this.driverRepository.findById(driver.getId())).thenReturn(Optional.of(driver));
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driverUpdate);

        DriverDto expected = new DriverDto(driverUpdate);

        DriverDto result = this.driverService.updateDriver(driver.getName(), driver.getAge(), driver.getId());

        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getName(), result.getName());
        Assertions.assertEquals(expected.getAge(), result.getAge());
    }

    @Test
    public void updateDriverFails(){
        DriverRequest request = new DriverRequest("test name", 20);
        Driver driver = new Driver(1, request.getName(), request.getAge());

        when(this.driverRepository.findById(driver.getId())).thenReturn(Optional.empty());

        DriverDto result = this.driverService.updateDriver(driver.getName(), driver.getAge(), driver.getId());
        Assertions.assertNull(result);
    }

    @Test
    public void deleteDriverSucessfully(){
        Driver driver = new Driver(1, "test", 20);

        when(this.driverRepository.findById(driver.getId())).thenReturn(Optional.of(driver));

        boolean isDeleted = this.driverService.deleteDriver(1);
        Assertions.assertTrue(isDeleted);
    }

    @Test
    public void deleteDriverFails(){
        Driver driver = new Driver(1, "test", 20);

        when(this.driverRepository.findById(driver.getId())).thenReturn(Optional.empty());

        boolean isDeleted = this.driverService.deleteDriver(1);
        Assertions.assertFalse(isDeleted);
    }
}
