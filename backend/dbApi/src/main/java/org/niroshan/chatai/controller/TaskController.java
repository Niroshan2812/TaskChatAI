package org.niroshan.chatai.controller;

import org.niroshan.chatai.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.niroshan.chatai.searvice.TaskSearvice;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*") // allow frontend access

public class TaskController {
    @Autowired
    private TaskSearvice taskSearvice;


    @GetMapping("/{userId}")
    public List<Task> getAllTasks(@PathVariable String userId){
        return taskSearvice.getAllTasks(userId);
    }

    @PostMapping
    public Task createTask(@RequestBody  Task task){
        return taskSearvice.createTask(task);
    }

    @GetMapping("/task/{id}")
    public Optional<Task> getTaskById(@PathVariable String id){
        return taskSearvice.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task UpdatedTask){
        return taskSearvice.updateTask(id, UpdatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskSearvice.deleteTask(id);
    }
}
