package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task;

import java.time.LocalDateTime;

public record TaskRequest(String title,
        Integer priority,
        String description,
        Double estimatedTime,
        LocalDateTime startTime,
        LocalDateTime finishTime) {

}
