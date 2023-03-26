package com.woohoo.wClinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woohoo.wClinica.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    
}
