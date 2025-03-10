package com.example.code_challenge4.controllers;


import com.example.code_challenge4.dto.DriverDto;
import com.example.code_challenge4.dto.DriverRequest;
import com.example.code_challenge4.repositories.DriverRepository;
import com.example.code_challenge4.services.DriverService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverController.class)
class DriverControllerTest {

    @MockBean
    private DriverService driverService;

    @MockBean
    private DriverRepository driverRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveDriverSuccess() throws Exception {

        DriverRequest driverRequest = new DriverRequest("test", 15);
        DriverDto driverDto = new DriverDto(1, driverRequest.getName(), driverRequest.getAge());

        when(driverService.saveDriver(driverRequest.getName(), driverRequest.getAge())).thenReturn(driverDto);

        mockMvc.perform(post("/api/v1/driver/save").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
