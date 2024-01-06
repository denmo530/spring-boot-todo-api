package com.todo.springboottodobackend.controllers;

import com.todo.springboottodobackend.models.Task;
import com.todo.springboottodobackend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get Routes
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.getAllCompletedTasks());
    }
    @GetMapping("/inComplete")
    public ResponseEntity<List<Task>> getAllInCompletedTasks() {
    return ResponseEntity.ok(taskService.getAllInCompletedTasks());
    }

    // Post Routes
    @PostMapping("/")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.addNewTask(task));
    }

    // Update Routes
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Task>> updateTask(@PathVariable String id, @RequestBody Task task) {
        return ResponseEntity.ok(Optional.ofNullable(taskService.updateTask(id, task)));
    }

    // Delete routes
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable String id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }





}
