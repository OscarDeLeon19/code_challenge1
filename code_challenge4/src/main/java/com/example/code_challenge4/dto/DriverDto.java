package com.example.code_challenge4.dto;

import com.example.code_challenge4.entities.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DriverDto {
    private Integer id;
    private String name;
    private Integer age;

    public DriverDto(Driver d) {
        this.id = d.getId();
        this.name = d.getName();
        this.age = d.getAge();
    }
}
