package com.microservice.citizenservice.repository;

import com.microservice.citizenservice.entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenEntity,Integer> {

    List<CitizenEntity> findByVaccinationCenterId(Integer id);
}
