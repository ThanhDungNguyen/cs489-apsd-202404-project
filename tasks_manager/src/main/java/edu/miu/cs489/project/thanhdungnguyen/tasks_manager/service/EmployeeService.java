package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import jakarta.validation.Valid;

public interface EmployeeService {
    EmployeeResponse addNewEmployee(@Valid EmployeeRequest employeeRequest);
}
