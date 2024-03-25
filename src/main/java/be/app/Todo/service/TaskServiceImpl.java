package be.app.Todo.service;

import be.app.Todo.dao.TaskDAO;
import be.app.Todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDAO taskDAO;

    @Override
    public Task getTask(String title) {
        return taskDAO.getTask(title);
    }

    @Override
    public List<Task> getTasks() {
        return taskDAO.getTasks();
    }

    @Override
    public Task addTask(Task task) {
        System.out.println(task.getDueDate());
        task.setIsDeleted(0);
        LocalDate localDate = LocalDate.now();
        task.setCreated(localDate);
        return taskDAO.addTask(task);
    }

    @Override
    public Task editTask(Task task) {
        return taskDAO.editTask(task);
    }

    @Override
    public Task deleteTask(Task task) {
        task.setIsDeleted(1);
        return taskDAO.deleteTask(task);
    }
}
