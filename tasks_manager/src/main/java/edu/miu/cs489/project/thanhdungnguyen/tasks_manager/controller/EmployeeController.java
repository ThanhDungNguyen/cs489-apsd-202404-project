package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeFullResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tskmgr/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        try {
            var addedEmployeeResponse = employeeService.addNewEmployee(employeeRequest);
            return new ResponseEntity<EmployeeResponse>(addedEmployeeResponse, HttpStatus.CREATED);
        } catch (DataNotFoundException exception) {
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId) {
        try {
            var employeeResponse = employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<EmployeeFullResponse>(employeeResponse, HttpStatus.OK);
        } catch (DataNotFoundException exception) {
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
