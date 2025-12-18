package com.TaskFlow.mainApp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class taskEntity {
    public void setId(Long id) {
        this.id = id;
    }

    public taskEntity() {
    }

    public taskEntity(Long id, String title, String description, LocalDateTime createdAt, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Status getStatus() {
        return status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_title",nullable = false)
    private String title;

    @Column(name = "task_description",nullable = false)
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt=LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status=Status.PENDING;

    public enum Status{
        PENDING,
        COMPLETED
    }

    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
        this.status=Status.PENDING;
    }


}
