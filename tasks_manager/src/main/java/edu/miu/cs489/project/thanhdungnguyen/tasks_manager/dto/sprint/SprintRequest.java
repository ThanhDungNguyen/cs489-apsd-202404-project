package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record SprintRequest(@NotBlank(message = "Sprint title is required") String title,
        LocalDate startDate,
        LocalDate endDate) {

}
