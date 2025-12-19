package com.TaskFlow.mainApp.controller;

import com.TaskFlow.mainApp.entity.taskEntity;
import com.TaskFlow.mainApp.service.taskService;
import jakarta.persistence.Enumerated;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://taskflow-frontend-nine-lilac.vercel.app")
@RequestMapping("/task")
public class taskController {
    taskService taskService;

    public taskController(taskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public String add(@RequestBody taskEntity taskEntity){
        taskService.addTask(taskEntity);
        return "Added Successfully";
    }
    @GetMapping
    public List<taskEntity> get(){
        return taskService.getTasks();
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        taskService.deleteAllTask();
        return "Deleted Successfully";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        taskService.deleteById(id);
        return  "Deleted Successfully";
    }
    @PutMapping("/{id}")
    public ResponseEntity<taskEntity> update(@PathVariable Long id ,
                                             @RequestBody taskEntity updatedTask) {
        return ResponseEntity.ok(taskService.updateTask(id,updatedTask));
    }

}
