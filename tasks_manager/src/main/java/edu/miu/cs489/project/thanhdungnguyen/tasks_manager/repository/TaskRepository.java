package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
