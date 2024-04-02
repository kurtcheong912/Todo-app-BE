package be.app.Todo.rest;

import be.app.Todo.entity.Task;
import be.app.Todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrackController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    @PreAuthorize("hasAuthority('ROLE_User')")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        if (task == null || task.getTitle().isBlank()) {
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
    }

    @GetMapping("/tasks")
    @PreAuthorize("hasAuthority('ROLE_User')")
    public ResponseEntity<?> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    @PreAuthorize("hasAuthority('ROLE_User')")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    @PreAuthorize("hasAuthority('ROLE_User')")
    public ResponseEntity<?> editTask(@PathVariable Long id, @RequestBody Task task) {
        if (task == null) {
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.editTask(task, id), HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    @PreAuthorize("hasAuthority('ROLE_User')")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
