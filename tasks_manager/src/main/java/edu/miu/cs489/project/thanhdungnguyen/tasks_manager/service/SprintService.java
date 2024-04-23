package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import jakarta.validation.Valid;

public interface SprintService {
    SprintResponse addNewSprint(@Valid SprintRequest sprintRequest);
}
