package com.deepak.productservice.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@MappedSuperclass // all the attributes to be added in child class
@Getter
@Setter
public class BaseModel {
    @Id //id column for my table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdBy = "Deepak";
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    private boolean isDeleted; //can be an enum

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = new Date();
    }
}
