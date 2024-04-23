package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import java.time.LocalDate;

public record SprintRequest(String title,
        LocalDate startDate,
        LocalDate endDate) {

}
