package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponseWithTasks;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.SprintRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.TaskRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.SprintService;
import jakarta.validation.Valid;

@Service
public class SprintServiceImpl implements SprintService {
    @Autowired
    private SprintRepository sprintRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public SprintResponseWithTasks getSprintWithTasks(Long sprintId) throws DataNotFoundException {
        var sprint = sprintRepository.findById(sprintId).orElseThrow(
                () -> new DataNotFoundException(String.format("Sprint with ID, %d, cannot be found", sprintId)));
        return SprintAdapter.getSprintResponseWithTasksFromSprint(sprint);
    }

    @Override
    public SprintResponse addNewSprint(@Valid SprintRequest sprintRequest) {
        var sprint = SprintAdapter.getSprintFromSprintRequest(sprintRequest);
        sprintRepository.save(sprint);
        return SprintAdapter.getSprintResponseFromSprint(sprint);
    }

    @Override
    public SprintResponseWithTasks addTask(Long sprintId, Long taskId) throws DataNotFoundException {
        var sprint = sprintRepository.findById(sprintId).orElseThrow(
                () -> new DataNotFoundException(String.format("Sprint with ID, %d, cannot be found", sprintId)));
        var task = taskRepository.findById(taskId)
                .orElseThrow(
                        () -> new DataNotFoundException(String.format("Task with ID, %d, cannot be found", taskId)));
        sprint.addTask(task);
        sprintRepository.save(sprint);
        return SprintAdapter.getSprintResponseWithTasksFromSprint(sprint);
    }

}
