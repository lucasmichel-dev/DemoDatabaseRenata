package com.example.demo.resources;

import com.example.demo.entities.Dog;
import com.example.demo.resources.request.DogDTO;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("/dog/{id}")
    public ResponseEntity<DogDTO> getDogById(@PathVariable Long id) {
        DogDTO dto = service.findDogById(id);

        if (dto != null)
            return ResponseEntity.ok().body(dto);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/dog/all")
    public ResponseEntity<List<DogDTO>> getAllDogs() {
        return ResponseEntity.ok(service.findAllDogs());
    }

    @PostMapping("/dog")
    public ResponseEntity<DogDTO> createNewDog(@RequestBody DogDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertDog(dto));
    }

}
