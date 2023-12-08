package com.example.project.repository;

import com.example.project.model.entity.Role;
import com.example.project.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByUserRole(UserRole userRole);
}
