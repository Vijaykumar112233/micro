package com.microservice.VaccinationCenter.repository;

import com.microservice.VaccinationCenter.entity.VaccinationCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenterEntity,Integer> {
}
