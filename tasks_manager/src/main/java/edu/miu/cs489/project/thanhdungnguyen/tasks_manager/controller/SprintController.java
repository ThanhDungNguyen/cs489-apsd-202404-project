package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponseWithTasks;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintStatusResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.SprintService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tskmgr/api/sprint")
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @GetMapping(value = "/{sprintId}")
    public ResponseEntity<SprintResponseWithTasks> getSprintWithTask(@PathVariable Long sprintId)
            throws DataNotFoundException {
        var sprintReponseWithTasks = sprintService.getSprintWithTasks(sprintId);
        return new ResponseEntity<>(sprintReponseWithTasks, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<SprintResponse> addNewSprint(@RequestBody @Valid SprintRequest sprintRequest) {
        var addedSprintResponse = sprintService.addNewSprint(sprintRequest);
        return new ResponseEntity<>(addedSprintResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{sprintId}/addtask/{taskId}")
    public ResponseEntity<SprintResponseWithTasks> addTaskToSprint(@PathVariable Long sprintId,
            @PathVariable Long taskId) throws DataNotFoundException {
        var updatedSprintResponse = sprintService.addTask(sprintId, taskId);
        return new ResponseEntity<>(updatedSprintResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{sprintId}/status")
    public ResponseEntity<SprintStatusResponse> getSprintStatus(@PathVariable Long sprintId)
            throws DataNotFoundException {
        var sprintReponseWithTasks = sprintService.getSprintStatus(sprintId);
        return new ResponseEntity<>(sprintReponseWithTasks, HttpStatus.OK);
    }
}
