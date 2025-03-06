package com.example.code_challenge4;


import entities.Driver;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.DriverRepository;
import services.DriverService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class DriverTest {

    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveDriverSuccess() {
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("test");
        driver.setAge(20);


        when(driverRepository.save(any(Driver.class))).thenReturn(driver);
    }

    @Test
    public void saveDriverFailure() {}

    @Test
    public void findDriversSuccess() {}

    @Test
    public void findDriversIsEmpty() {}
}
