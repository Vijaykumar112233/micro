package com.microservice.VaccinationCenter.model;

import com.microservice.VaccinationCenter.entity.VaccinationCenterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private VaccinationCenterEntity vaccinationCenter;
    private List<Citizen> citizenList;
}
