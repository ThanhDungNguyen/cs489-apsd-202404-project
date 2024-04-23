package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model;

import java.time.LocalDate;
import java.util.List;

public class Sprint {
    private Long sprintId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;
}
