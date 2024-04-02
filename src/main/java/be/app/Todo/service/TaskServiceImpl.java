package be.app.Todo.service;

import be.app.Todo.dao.TaskDAO;
import be.app.Todo.entity.Task;
import be.app.Todo.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDAO taskDAO;

    @Override
    public Task getTask(Long id) {
        Task task = taskDAO.getTask(id);
        if (task == null) {
            throw new NotFoundException("Task not found id :" + id);
        }
        return task;
    }

    @Override
    public List<Task> getTasks() {
        return taskDAO.getTasks();
    }

    @Override
    @Transactional
    public Task addTask(Task task) {
        task.setIsDeleted(false);
        LocalDateTime localDateTime = LocalDateTime.now();
        task.setCreated(localDateTime);
        return taskDAO.addTask(task);
    }

    @Override
    @Transactional
    public Task editTask(Task task, Long id) {
        Task oldTask = taskDAO.getTask(id);
        if (oldTask == null) {
            throw new NotFoundException("Task not found id :" + task.getTitle());
        }
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setDueDate(task.getDueDate());
        oldTask.setCategory(task.getCategory());
        LocalDateTime localDateTime = LocalDateTime.now();
        oldTask.setUpdated(localDateTime);
        return taskDAO.editTask(oldTask);
    }

    @Override
    @Transactional
    public Task deleteTask(Long id) {
        Task task = taskDAO.getTask(id);
        if (task == null) {
            throw new NotFoundException("Task not found id :" + id);
        }
        task.setIsDeleted(true);
        return taskDAO.deleteTask(task);
    }
}
