package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.NoDataException;
import jakarta.validation.Valid;

public interface EmployeeService {
    EmployeeResponse addNewEmployee(@Valid EmployeeRequest employeeRequest)throws NoDataException;
}
