package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.EmployeeRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.EmployeeService;
import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse addNewEmployee(@Valid EmployeeRequest employeeRequest) {
        var employee = EmployeeAdapter.getEmployeeFromEmployeeRequest(employeeRequest);
        employeeRepository.save(employee);
        return EmployeeAdapter.getEmployeeResponseFromEmployee(employee);
    }

}
