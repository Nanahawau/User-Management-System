package com.nana.usermanagementsystem.repositories;

import com.nana.usermanagementsystem.entities.Role;
import com.nana.usermanagementsystem.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
