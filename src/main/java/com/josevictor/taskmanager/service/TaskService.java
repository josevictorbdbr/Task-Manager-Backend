package com.josevictor.taskmanager.service;
import org.springframework.stereotype.Service;

import com.josevictor.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(String title){
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }
}
