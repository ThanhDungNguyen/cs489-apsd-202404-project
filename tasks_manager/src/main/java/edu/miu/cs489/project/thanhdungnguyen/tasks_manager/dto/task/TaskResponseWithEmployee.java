package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task;

import java.time.LocalDateTime;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeResponse;

public record TaskResponseWithEmployee(Long id,
        String title,
        Integer priority,
        String description,
        Double estimatedTime,
        LocalDateTime startTime,
        LocalDateTime finishTime,
        EmployeeResponse assignedEmployee) {

}
