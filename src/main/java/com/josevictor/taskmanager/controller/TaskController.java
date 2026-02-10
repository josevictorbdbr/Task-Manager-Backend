package com.josevictor.taskmanager.controller;

import com.josevictor.taskmanager.model.TaskRequest;
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

    //Post
    @PostMapping
    public Task createTask(@RequestBody TaskRequest request){
        return taskService.createTask(request.getTitle());
    }

    //Get
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    //Put
    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestParam boolean completed
    ){
        return taskService.updateTask(id, completed);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }


}
