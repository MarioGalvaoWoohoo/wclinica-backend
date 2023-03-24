package com.woohoo.wClinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woohoo.wClinica.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}
