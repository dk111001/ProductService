package com.deepak.productservice.models;

import lombok.Data;

import java.util.Date;
@Data
public class BaseModel {
    private Long id;
    private String createdBy;
    private Date createdAt;
    private boolean isDeleted; //can be an enum
}
