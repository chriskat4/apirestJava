package com.Api.tcc.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Api.tcc.models.TaskModel;


public interface TaskRepository extends JpaRepository<TaskModel, UUID>{
    @Query(value = "SELECT * FROM tb_task WHERE user_id = :id", nativeQuery = true)
    List<TaskModel> findTaskByUserId(UUID id);

    @Query(value = "SELECT * FROM tb_task WHERE task = :task", nativeQuery = true )
    TaskModel findTaskByTask(String task);
}
