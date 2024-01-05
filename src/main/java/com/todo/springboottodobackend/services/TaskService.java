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

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public Task updateTask(String id, Task taskDetails) {
//        Optional<Task> taskOptional = taskRepository.findById(id);
//        if (taskOptional.isPresent()) {
//            Task existingTask = taskOptional.get();
//            return taskRepository.save(taskDetails);
//        }

    return taskDetails;
    }


}
