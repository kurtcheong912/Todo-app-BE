package be.app.Todo.dao;

import be.app.Todo.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public Task getTask(Long id) {

        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> getTasks() {
        TypedQuery<Task> query = entityManager.createQuery(
                "select i from Task i "
                        + "where isDeleted = :data"
                , Task.class);
        query.setParameter("data", false);
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
