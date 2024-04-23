package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.SprintRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.SprintService;
import jakarta.validation.Valid;

public class SprintServiceImpl implements SprintService {
    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public SprintResponse addNewSprint(@Valid SprintRequest sprintRequest) {
        var sprint = SprintAdapter.getSprintFromSprintRequest(sprintRequest);
        sprintRepository.save(sprint);
        return SprintAdapter.getSprintResponseFromSprint(sprint);
    }

}
