package com.woohoo.wClinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woohoo.wClinica.models.AccessType;

@Repository
public interface AccessTypeRepository extends JpaRepository<AccessType, Long>{
    
}
