package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDateTime;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @NotBlank(message = "Task title is required")
    private String title;
    private Integer priority;
    private String description;
    private Double estimatedTime; // Estimated time in hour to finish the task
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    @ManyToOne
    private Employee assignedEmployee;

    public void update(TaskRequest taskRequest) {
        if (taskRequest.title() != null)
            title = taskRequest.title();
        if (taskRequest.priority() != null)
            priority = taskRequest.priority();
        if (taskRequest.description() != null)
            description = taskRequest.description();
        if (taskRequest.estimatedTime() != null)
            estimatedTime = taskRequest.estimatedTime();
        if (taskRequest.startTime() != null)
            startTime = taskRequest.startTime();
        if (taskRequest.finishTime() != null)
            finishTime = taskRequest.finishTime();
    }
}
