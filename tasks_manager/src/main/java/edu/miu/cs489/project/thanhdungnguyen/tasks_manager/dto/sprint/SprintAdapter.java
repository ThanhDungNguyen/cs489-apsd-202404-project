package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.sprint;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.task.TaskAdapter;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Sprint;

public class SprintAdapter {
    public static Sprint getSprintFromSprintRequest(SprintRequest sprintRequest) {
        return new Sprint(null, sprintRequest.title(), sprintRequest.startDate(), sprintRequest.endDate(), null);
    }

    public static SprintResponse getSprintResponseFromSprint(Sprint sprint) {
        var taskResponses = sprint.getTasks().stream().map(task -> TaskAdapter.getTaskResponseFromTask(task)).toList();
        return new SprintResponse(sprint.getSprintId(), sprint.getTitle(), sprint.getStartDate(), sprint.getEndDate(),
                taskResponses);
    }
}
