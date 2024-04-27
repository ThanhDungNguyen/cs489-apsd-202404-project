package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import java.util.Comparator;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Sprint;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Task;

public class SprintAdapter {
    public static Sprint getSprintFromSprintRequest(SprintRequest sprintRequest) {
        return new Sprint(null, sprintRequest.title(), sprintRequest.startDate(), sprintRequest.endDate(), null);
    }

    public static SprintResponse getSprintResponseFromSprint(Sprint sprint) {
        return new SprintResponse(sprint.getSprintId(), sprint.getTitle(), sprint.getStartDate(), sprint.getEndDate());
    }

    public static SprintResponseWithTasks getSprintResponseWithTasksFromSprint(Sprint sprint) {
        var taskResponses = sprint.getTasks().stream().sorted(Comparator.comparing(Task::getPriority))
                .map(task -> TaskAdapter.getTaskResponseFromTask(task)).toList();
        return new SprintResponseWithTasks(sprint.getSprintId(), sprint.getTitle(), sprint.getStartDate(),
                sprint.getEndDate(),
                taskResponses);
    }
}
