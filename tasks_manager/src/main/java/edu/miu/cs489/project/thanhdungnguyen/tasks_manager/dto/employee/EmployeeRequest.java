package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee;

public record EmployeeRequest(String firstName,
        String lastName,
        String position,
        String username,
        String password,
        Long managerId) {

}
