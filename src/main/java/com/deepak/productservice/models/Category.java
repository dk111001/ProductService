package com.deepak.productservice.models;

import java.util.Date;

public class Category extends BaseModel{
    private Long id;
    private String createBy;
    private Date createdAt;
    private Boolean isDeleted; // This can be an Enum as well.
}
