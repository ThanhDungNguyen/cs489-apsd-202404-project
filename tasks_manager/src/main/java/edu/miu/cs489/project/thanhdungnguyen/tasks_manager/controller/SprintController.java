package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint.SprintResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.SprintService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tskmgr/api/sprint")
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @PostMapping(value = "/add")
    public ResponseEntity<SprintResponse> addNewSprint(@RequestBody @Valid SprintRequest sprintRequest) {
        var addedSprintResponse = sprintService.addNewSprint(sprintRequest);
        return new ResponseEntity<>(addedSprintResponse, HttpStatus.CREATED);
    }
}
