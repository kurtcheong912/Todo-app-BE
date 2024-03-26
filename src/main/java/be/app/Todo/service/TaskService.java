package be.app.Todo.service;

import be.app.Todo.entity.Task;

import java.util.List;

public interface TaskService {
    Task getTask(Long id);

    List<Task> getTasks();

    Task addTask(Task task);

    Task editTask(Task task,Long id);

    Task deleteTask(Long id);
}
