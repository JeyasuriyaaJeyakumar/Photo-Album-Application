package com.example.assignment6.service;


import com.example.assignment6.model.Photo;
import com.example.assignment6.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getAllPhoto() {
        return photoRepository.findAll();
    }
    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }


    public void deletePhoto(String id) {
          photoRepository.deleteById(id);
    }

    public Photo getPhotoById(String id) {
        return photoRepository.findById(id).get();
    }

}
