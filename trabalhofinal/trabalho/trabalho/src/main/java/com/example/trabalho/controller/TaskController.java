package com.example.trabalho.controller;

import com.example.trabalho.model.Task;
import com.example.trabalho.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/get")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/post")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("/edit/{id}")
    public Task editTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.editTask(task, id);
    }

    @PutMapping("/status/{id}")
    public Task updateStatus(@PathVariable int id) {
        return taskService.updateStatus(id);
    }

    @PutMapping("/priority/{id}")
    public Task updatePriority(@PathVariable int id) {
        return taskService.updatePriority(id);
    }

    @GetMapping("/get/filterstatus/{status}")
    public List<Task> getTaskStatus(@PathVariable int status) {
        return taskService.getTasksStatus(status);
    }

    @GetMapping("/get/filterpriority/{priority}")
    public List<Task> getTaskPriority(@PathVariable int priority) {
        return taskService.getTasksPriority(priority);
    }


}
