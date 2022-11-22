package com.example.assignment6.model;


import com.example.assignment6.validation.ValidName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Photo {
    @Id
    private String id;
    private int albumId;
    private String coverPhotoUrl;
    @ValidName
    private String createdBy;
    @CreatedDate
    private Date dateCreated;

    public Photo(int albumId, String coverPhotoUrl, String createdBy) {
        this.albumId = albumId;
        this.coverPhotoUrl = coverPhotoUrl;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
