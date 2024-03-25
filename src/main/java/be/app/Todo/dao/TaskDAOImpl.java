package be.app.Todo.dao;

import be.app.Todo.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    EntityManager entityManager;

    @Override
    public Task getTask(String title) {
        return entityManager.find(Task.class, title);
    }

    @Override
    public List<Task> getTasks() {
        TypedQuery<Task> query = entityManager.createQuery(
                "select i from Task i "
                , Task.class);
        List<Task> task = query.getResultList();
        return task;
    }

    @Override
    public Task addTask(Task task) {
        entityManager.persist(task);
        return task;
    }

    @Override
    public Task editTask(Task task) {
        return entityManager.merge(task);
    }

    @Override
    public Task deleteTask(Task task) {
        return entityManager.merge(task);
    }
}
