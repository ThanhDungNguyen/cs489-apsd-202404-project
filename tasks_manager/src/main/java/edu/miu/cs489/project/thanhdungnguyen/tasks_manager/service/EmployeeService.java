package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeFullResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import jakarta.validation.Valid;

public interface EmployeeService {
    EmployeeFullResponse addNewEmployee(@Valid EmployeeRequest employeeRequest) throws DataNotFoundException;

    EmployeeFullResponse getEmployeeById(Long employeeId) throws DataNotFoundException;
}
