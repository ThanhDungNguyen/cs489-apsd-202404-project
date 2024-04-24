package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee;

import java.util.List;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;

public record EmployeeFullResponse(Long employeeId,
        String firstName,
        String lastName,
        String position,
        EmployeeResponse manager,
        List<TaskResponse> tasks) {

}
