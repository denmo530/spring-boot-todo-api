package com.todo.springboottodobackend.services;

import com.todo.springboottodobackend.models.Task;
import com.todo.springboottodobackend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addNewTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllCompletedTasks() {
        return taskRepository.findTasksByCompletedTrue();
    }

    public List<Task> getAllInCompletedTasks() {
        return taskRepository.findTasksByCompletedFalse();
    }

    public void deleteTask(String id)
    {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty()) throw new RuntimeException("Task not found with id: " + id);

        taskRepository.deleteById(id);
    }

    public Task updateTask(String id, Task taskDetails) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty()) throw new RuntimeException("Task not found with id: " + id);

        Task existingTask = taskOptional.get();

        existingTask.setTaskTitle(taskDetails.getTaskTitle());
        existingTask.setCompleted(taskDetails.isCompleted());

        return taskRepository.save(existingTask);
    }
}
