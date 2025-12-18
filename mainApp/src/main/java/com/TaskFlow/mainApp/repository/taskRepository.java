package com.TaskFlow.mainApp.repository;

import com.TaskFlow.mainApp.entity.taskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<taskEntity,Long> {

}
