package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record TaskRequest(@NotBlank(message = "Task title is required") String title,
        Integer priority,
        String description,
        Double estimatedTime,
        LocalDateTime startTime,
        LocalDateTime finishTime) {

}
