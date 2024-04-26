package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeFullResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Role;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.EmployeeRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.RoleRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.EmployeeService;
import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public EmployeeResponse addNewEmployee(@Valid EmployeeRequest employeeRequest) throws DataNotFoundException {
        var employee = EmployeeAdapter.getEmployeeFromEmployeeRequest(employeeRequest);

        var managerId = employeeRequest.managerId();
        var manager = managerId == null ? null
                : employeeRepository.findById(managerId).orElseThrow(
                        () -> new DataNotFoundException(String.format("No manager with ID, %d, was found", managerId)));
        employee.setManager(manager);

        var roles = new ArrayList<Role>();
        for (var requestedRole : employeeRequest.roles()) {
            var role = roleRepository.findByName(requestedRole);
            if (role.isPresent()) {
                roles.add(role.get());
            } else {
                var newRole = new Role(null, requestedRole, null);
                roleRepository.save(newRole);
                roles.add(newRole);
            }
        }

        employeeRepository.save(employee);
        return EmployeeAdapter.getEmployeeResponseFromEmployee(employee);
    }

    @Override
    public EmployeeFullResponse getEmployeeById(Long employeeId) throws DataNotFoundException {
        var employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new DataNotFoundException(String.format("No employee with ID, %d, was found", employeeId)));
        return EmployeeAdapter.getEmployeeFullResponseFromEmployee(employee);
    }

}
