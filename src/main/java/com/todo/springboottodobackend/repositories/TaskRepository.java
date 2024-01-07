package com.todo.springboottodobackend.repositories;

import com.todo.springboottodobackend.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    @Query("{taskTitle: '?0'}")
    Task findTaskByTitle(String title);

    List<Task> findTasksByCompletedTrue();

    List<Task> findTasksByCompletedFalse();

    public long count();
}
