package com.recrute.backend.repositories;

import java.util.Optional;

import com.recrute.backend.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
}
