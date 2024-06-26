package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponseWithEmployee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.DataNotFoundException;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Task;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.EmployeeRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.TaskRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.TaskService;
import jakarta.validation.Valid;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<TaskResponse> getAllTasks() {
        var tasks = taskRepository.findAll();
        return tasks.stream().sorted(Comparator.comparing(Task::getPriority))
                .map(task -> TaskAdapter.getTaskResponseFromTask(task)).toList();
    }

    @Override
    public TaskResponse addNewTask(@Valid TaskRequest taskRequest) {
        var task = TaskAdapter.getTaskFromTaskRequest(taskRequest);
        taskRepository.save(task);
        return TaskAdapter.getTaskResponseFromTask(task);
    }

    @Override
    public TaskResponseWithEmployee assignTaskToEmployee(Long taskId, Long employeeId) throws DataNotFoundException {
        var task = taskRepository.findById(taskId)
                .orElseThrow(
                        () -> new DataNotFoundException(String.format("Task with ID, %d, cannot be found", taskId)));
        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new DataNotFoundException(
                                String.format("Employee with ID, %d, cannot be found", employeeId)));
        task.setAssignedEmployee(employee);
        taskRepository.save(task);
        return TaskAdapter.getTaskResponseWithEmployeeFromTask(task);
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest updatedTask) throws DataNotFoundException {
        var task = taskRepository.findById(taskId)
                .orElseThrow(
                        () -> new DataNotFoundException(String.format("Task with ID, %d, cannot be found", taskId)));
        task.update(updatedTask);
        taskRepository.save(task);
        return TaskAdapter.getTaskResponseFromTask(task);
    }

}
