package com.example.demo.resources.request;

import com.example.demo.entities.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DogDTO {

    private Long id;
    private String name;
    private Integer age;
    private String race;
    private String owner;

    public Dog toEntity() {
        return new Dog(id, name, age, race, owner);
    }
}
