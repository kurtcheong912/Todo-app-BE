package be.app.Todo.rest;

import be.app.Todo.entity.Task;
import be.app.Todo.service.TaskService;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrackController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        if(task==null|| task.getTitle().isBlank()){
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        if(id ==null){
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> editTask(@PathVariable Long id, @RequestBody Task task) {
        if(task==null){
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.editTask(task, id), HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if(id==null){
            return new ResponseEntity<>("Request body does not match requirement", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
