package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee;

public record EmployeeResponse(Long employeeId,
        String firstName,
        String lastName,
        String position,
        EmployeeResponse manager) {

}
