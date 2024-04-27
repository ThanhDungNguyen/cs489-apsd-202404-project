package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponseWithTasks;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintStatusResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import jakarta.validation.Valid;

public interface SprintService {
    SprintResponseWithTasks getSprintWithTasks(Long sprintId) throws DataNotFoundException;

    SprintResponse addNewSprint(@Valid SprintRequest sprintRequest);

    SprintResponseWithTasks addTask(Long sprintId, Long taskId) throws DataNotFoundException;

    SprintStatusResponse getSprintStatus(Long sprintId) throws DataNotFoundException;
}
