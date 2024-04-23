package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sprintId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany
    @JoinColumn(name="sprint_id")
    private List<Task> tasks;
}
