package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
