package com.josevictor.taskmanager.service;
import org.springframework.stereotype.Service;

import com.josevictor.taskmanager.exception.InvalidTaskException;
import com.josevictor.taskmanager.exception.TaskNotFoundException;
import com.josevictor.taskmanager.model.Task;
import com.josevictor.taskmanager.repository.TaskRepository;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    //Spring automatically injects Task Repository via constructor
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(String title){
        //Prevents creating tasks with empty title
        if(title == null || title.isBlank()){
            throw new InvalidTaskException("Title cannot be empty");
        }

        Task task = new Task(title);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, boolean completed){
        //Finds the task by ID
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task was not found"));

        task.setCompleted(completed);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        // Verify if the record exists
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Task was not found");
        }
        taskRepository.deleteById(id);
    }

}