package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponseWithEmployee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "tskmgr/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        var taskReponses = taskService.getAllTasks();
        return new ResponseEntity<>(taskReponses, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<TaskResponse> addNewTask(@RequestBody @Valid TaskRequest taskRequest) {
        var newTaskResponse = taskService.addNewTask(taskRequest);
        return new ResponseEntity<>(newTaskResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{taskId}/assign/{employeeId}")
    public ResponseEntity<?> assignTaskToEmployee(@PathVariable Long taskId, @PathVariable Long employeeId)
            throws DataNotFoundException {
        var updatedTaskResponse = taskService.assignTaskToEmployee(taskId, employeeId);
        return new ResponseEntity<TaskResponseWithEmployee>(updatedTaskResponse, HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/{taskId}/edit")
    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest)
            throws DataNotFoundException {
        var updatedTaskResponse = taskService.updateTask(taskId, taskRequest);
        return new ResponseEntity<TaskResponseWithEmployee>(updatedTaskResponse, HttpStatus.ACCEPTED);
    }
}
