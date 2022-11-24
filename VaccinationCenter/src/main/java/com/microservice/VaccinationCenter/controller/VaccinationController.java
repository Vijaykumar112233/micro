package com.microservice.VaccinationCenter.controller;

import com.microservice.VaccinationCenter.entity.VaccinationCenterEntity;
import com.microservice.VaccinationCenter.model.Citizen;
import com.microservice.VaccinationCenter.model.RequiredResponse;
import com.microservice.VaccinationCenter.repository.VaccinationCenterRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VaccinationCenterRepository centerRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenterEntity> savedata(@RequestBody VaccinationCenterEntity vaccinationCenter){
        VaccinationCenterEntity list = centerRepository.save(vaccinationCenter);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequiredResponse> getdatabyid(@PathVariable Integer id){
        RequiredResponse response = new RequiredResponse();

        VaccinationCenterEntity vaccinationCenter = centerRepository.findById(id).get();
        response.setVaccinationCenter(vaccinationCenter);

        List<Citizen> list = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id,List.class);
        response.setCitizenList(list);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
        VaccinationCenterEntity vaccinationCenter = centerRepository.findById(id).get();
        RequiredResponse response = new RequiredResponse();
        response.setVaccinationCenter(vaccinationCenter);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
