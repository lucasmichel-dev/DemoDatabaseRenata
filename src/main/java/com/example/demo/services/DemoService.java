package com.example.demo.services;

import com.example.demo.entities.Dog;
import com.example.demo.repositories.DemoRepository;
import com.example.demo.resources.request.DogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemoService {

    @Autowired
    private DemoRepository repository;

    public DogDTO findDogById(Long id) {
        Optional<Dog> dog = repository.findById(id);
        return dog.map(Dog::toDTO).orElse(null);
    }

    public List<DogDTO> findAllDogs() {
        return repository
                .findAll()
                .stream()
                .map(Dog::toDTO)
                .collect(Collectors.toList());
    }

    public DogDTO insertDog(DogDTO dto) {
        return repository.save(dto.toEntity()).toDTO();
    }
}
