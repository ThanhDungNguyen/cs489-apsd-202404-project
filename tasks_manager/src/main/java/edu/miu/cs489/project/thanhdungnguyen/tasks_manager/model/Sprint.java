package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sprints")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sprintId;
    @NotBlank(message = "Sprint title is required")
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany
    @JoinColumn(name = "sprint_id")
    private List<Task> tasks;
}
