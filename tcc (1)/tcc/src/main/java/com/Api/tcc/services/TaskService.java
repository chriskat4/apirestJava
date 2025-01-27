package com.Api.tcc.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.Api.tcc.dtos.TaskDto;
import com.Api.tcc.models.TaskModel;
import com.Api.tcc.models.UserModel;
import com.Api.tcc.repositories.TaskRepository;
import com.Api.tcc.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskModel> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<List<TaskModel>> getTaskByUserId(UUID id){
        return Optional.of(taskRepository.findTaskByUserId(id));
    }

    public String saveTasks(TaskDto taskDto){
        
        for(String t: taskDto.tasks().stream().collect(Collectors.toSet())){
            TaskModel task = new TaskModel();
            task.setTask(t);
            task.setUser(userRepository.findById(taskDto.userID()).get());
            taskRepository.save(task);
        }

        return "Saved";
    }

}
