package com.recrute.backend.repositories;

import java.util.Optional;

import com.recrute.backend.models.ERole;
import com.recrute.backend.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
