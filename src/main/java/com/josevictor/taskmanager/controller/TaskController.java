package com.josevictor.taskmanager.controller;

import com.josevictor.taskmanager.service.TaskService;
import com.josevictor.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {

        return taskService.getAllTasks();
    }


    @PostMapping
    public Task createTask(@RequestBody String title){
        return taskService.createTask(title);
    }

}
