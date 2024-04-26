package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponseWithEmployee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import jakarta.validation.Valid;

public interface TaskService {
    TaskResponse addNewTask(@Valid TaskRequest taskRequest);

    TaskResponseWithEmployee assignTaskToEmployee(Long taskId, Long employeeId) throws DataNotFoundException;

    TaskResponseWithEmployee updateTask(Long taskId, TaskRequest updatedTask) throws DataNotFoundException;
}
