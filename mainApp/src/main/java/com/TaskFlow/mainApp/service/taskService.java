package com.TaskFlow.mainApp.service;

import com.TaskFlow.mainApp.entity.taskEntity;
import com.TaskFlow.mainApp.repository.taskRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taskService {
    taskRepository taskRepository;

    public taskService(taskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String addTask(taskEntity taskEntity){
        taskRepository.save(taskEntity);
        return "Added Successfully";
    }

    public List<taskEntity> getTasks(){
        return taskRepository.findAll();
    }

    public String deleteAllTask(){
        taskRepository.deleteAll();
        return "Deleted Successfully";
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public taskEntity updateTask(Long id,taskEntity updatedTask) {
            taskEntity  existTask=taskRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Task Not found"));
            existTask.setTitle(updatedTask.getTitle());
            existTask.setDescription(updatedTask.getDescription());
            existTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(updatedTask);
    }
}
