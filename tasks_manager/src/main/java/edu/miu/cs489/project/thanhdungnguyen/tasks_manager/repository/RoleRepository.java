package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
