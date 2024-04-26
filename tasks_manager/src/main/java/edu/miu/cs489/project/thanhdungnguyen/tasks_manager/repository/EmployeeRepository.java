package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<UserDetails> findByUsername(String username);
}
