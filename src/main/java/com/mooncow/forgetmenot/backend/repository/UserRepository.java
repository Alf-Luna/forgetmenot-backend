package com.mooncow.forgetmenot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooncow.forgetmenot.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
