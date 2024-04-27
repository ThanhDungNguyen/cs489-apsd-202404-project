package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import java.time.LocalDate;
import java.util.List;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;

public record SprintStatusResponse(Long sprintId,
        String title,
        LocalDate startDate,
        LocalDate endDate,
        List<TaskResponse> pendingTasks,
        List<TaskResponse> onGoingTasks,
        List<TaskResponse> finishedTasks) {

}
