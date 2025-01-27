package com.Api.tcc.controllers;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.tcc.dtos.TaskDto;
import com.Api.tcc.models.TaskModel;
import com.Api.tcc.services.TaskService;

@RestController
@RequestMapping("/Task/Tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<TaskModel>>> getAllTaskByUserId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskByUserId(id));
    }
    
    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody TaskDto taskDto){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.saveTasks(taskDto));
    }


}
