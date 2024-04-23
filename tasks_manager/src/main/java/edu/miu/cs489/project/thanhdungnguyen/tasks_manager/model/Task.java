package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDateTime;

public class Task {
    private Long taskId;
    private String title;
    private Integer priority;
    private String description;
    private Double estimatedTime; // Estimated time in hour to finish the task
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private Employee assignedEmployee;
}
