package com.example.assignment6.model;


import com.example.assignment6.validation.ValidName;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Comment {

    @Id
    private String id;
    private String photoId;
    @Length(min = 5)
    private String message;
    @ValidName
    private String createdBy;
    @CreatedDate
    private Date dateCreated;

    public Comment(String photoId, String message, String createdBy) {
        this.photoId = photoId;
        this.message = message;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}
