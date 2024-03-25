package be.app.Todo.rest;

import be.app.Todo.entity.Task;
import be.app.Todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrackController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<?> addOwner(@RequestBody Task task) {
        return new ResponseEntity<>(  taskService.addTask(task), HttpStatus.OK);
    }
}
