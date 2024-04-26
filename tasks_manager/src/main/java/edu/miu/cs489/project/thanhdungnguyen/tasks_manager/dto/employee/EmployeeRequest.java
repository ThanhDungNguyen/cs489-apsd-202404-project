package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee;

import java.util.List;

public record EmployeeRequest(String firstName,
        String lastName,
        String position,
        String username,
        String password,
        String email,
        Long managerId,
        List<String> roles) {

}
