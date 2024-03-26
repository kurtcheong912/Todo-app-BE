package be.app.Todo.dao;


import be.app.Todo.entity.Task;

import java.util.List;

public interface TaskDAO {
    Task getTask(Long id);

    List<Task> getTasks();

    Task addTask(Task task);

    Task editTask(Task task);

    Task deleteTask(Task task);
}
