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

    public Task updateTask(Long id,boolean completed){
        for (Task task : tasks){
            if(task.getId().equals(id)){
                task.setCompleted(completed);
                return task;
            }
        }
        throw new RuntimeException("Task was not found");
    }

    public void deleteTask(Long id){
        boolean removed = tasks.removeIf(task -> task.getId().equals(id));

        if(!removed){
            throw new RuntimeException("Task was not found");
        }
    }

}
