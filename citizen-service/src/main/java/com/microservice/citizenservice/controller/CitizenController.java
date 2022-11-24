package com.microservice.citizenservice.controller;

import com.microservice.citizenservice.entity.CitizenEntity;
import com.microservice.citizenservice.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<List<CitizenEntity>> getById(@PathVariable Integer id){
        List<CitizenEntity> list = citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CitizenEntity> savedata(@RequestBody CitizenEntity citizen){
        CitizenEntity list = citizenRepository.save(citizen);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
