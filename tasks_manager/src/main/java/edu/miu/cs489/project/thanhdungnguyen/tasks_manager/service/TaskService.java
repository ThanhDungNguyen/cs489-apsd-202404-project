package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import jakarta.validation.Valid;

public interface TaskService {
    TaskResponse addNewTask(@Valid TaskRequest taskRequest);
}
