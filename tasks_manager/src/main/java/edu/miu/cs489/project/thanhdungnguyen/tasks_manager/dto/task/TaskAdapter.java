package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee.EmployeeAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Task;

public class TaskAdapter {
    public static Task getTaskFromTaskRequest(TaskRequest taskRequest) {
        return new Task(null, taskRequest.title(), taskRequest.priority(), taskRequest.description(),
                taskRequest.estimatedTime(), taskRequest.startTime(), taskRequest.finishTime(), null);
    }

    public static TaskResponse getTaskResponseFromTask(Task task) {
        var employeeResponse = EmployeeAdapter.getEmployeeResponseFromEmployee(task.getAssignedEmployee());
        return new TaskResponse(task.getTitle(), task.getPriority(), task.getDescription(), task.getEstimatedTime(),
                task.getStartTime(), task.getFinishTime(), employeeResponse);
    }
}
