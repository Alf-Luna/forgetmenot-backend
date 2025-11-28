package com.mooncow.forgetmenot.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooncow.forgetmenot.backend.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByIdUsuario(String idUsuario);
}
