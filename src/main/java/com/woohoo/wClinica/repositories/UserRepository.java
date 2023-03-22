package com.woohoo.wClinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woohoo.wClinica.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
