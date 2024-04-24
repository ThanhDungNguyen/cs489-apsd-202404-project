package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponseWithEmployee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.NoDataException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "tskmgr/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/add")
    public ResponseEntity<TaskResponse> addNewTask(@RequestBody @Valid TaskRequest taskRequest) {
        var newTaskResponse = taskService.addNewTask(taskRequest);
        return new ResponseEntity<>(newTaskResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{taskId}/assign/{employeeId}")
    public ResponseEntity<?> assignTaskToEmployee(@PathVariable Long taskId, @PathVariable Long employeeId) {
        try {
            var updatedTaskResponse = taskService.assignTaskToEmployee(taskId, employeeId);
            return new ResponseEntity<TaskResponseWithEmployee>(updatedTaskResponse, HttpStatus.ACCEPTED);
        } catch (NoDataException exception) {
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
