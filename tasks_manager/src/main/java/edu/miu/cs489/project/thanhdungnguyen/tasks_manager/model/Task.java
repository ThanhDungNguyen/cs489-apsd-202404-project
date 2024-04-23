package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private Integer priority;
    private String description;
    private Double estimatedTime; // Estimated time in hour to finish the task
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    @ManyToOne
    private Employee assignedEmployee;
}
