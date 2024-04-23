package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import java.time.LocalDate;
import java.util.List;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;

public record SprintResponseWithTasks(Long sprintId,
        String title,
        LocalDate startDate,
        LocalDate endDate,
        List<TaskResponse> tasks) {

}
