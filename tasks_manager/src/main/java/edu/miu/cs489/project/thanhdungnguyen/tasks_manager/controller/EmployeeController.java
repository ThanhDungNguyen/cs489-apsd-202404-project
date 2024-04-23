package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tskmgr/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<EmployeeResponse> addNewEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        var addedEmployeeResponse = employeeService.addNewEmployee(employeeRequest);
        return new ResponseEntity<>(addedEmployeeResponse, HttpStatus.CREATED);
    }
}
