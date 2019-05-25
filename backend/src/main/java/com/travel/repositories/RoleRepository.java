package com.travel.repositories;

import java.util.List;

import com.travel.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    List<Role> findByName(String name);
}