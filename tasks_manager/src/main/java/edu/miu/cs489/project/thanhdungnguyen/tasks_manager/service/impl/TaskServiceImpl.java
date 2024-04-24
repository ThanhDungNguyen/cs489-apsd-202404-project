package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskRequest;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponse;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskResponseWithEmployee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.exception.NoDataException;
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
    public TaskResponse addNewTask(@Valid TaskRequest taskRequest) {
        var task = TaskAdapter.getTaskFromTaskRequest(taskRequest);
        taskRepository.save(task);
        return TaskAdapter.getTaskResponseFromTask(task);
    }

    @Override
    public TaskResponseWithEmployee assignTaskToEmployee(Long taskId, Long employeeId) throws NoDataException {
        var task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NoDataException(String.format("Task with ID, %d, cannot be found", taskId)));
        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new NoDataException(String.format("Employee with ID, %d, cannot be found", employeeId)));
        task.setAssignedEmployee(employee);
        taskRepository.save(task);
        return TaskAdapter.getTaskResponseWithEmployeeFromTask(task);
    }

}
