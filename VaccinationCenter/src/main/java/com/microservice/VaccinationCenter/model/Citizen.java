package com.microservice.VaccinationCenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

    private Integer id;
    private String name;
    private int vaccinationCenterId;

}
