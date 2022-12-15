package com.example.assignment6.service;



import com.example.assignment6.model.Album;
import com.example.assignment6.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }
    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }
    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }
    public Album updateAlbumCover(Album coverPhotoUrl){
       return albumRepository.save(coverPhotoUrl);
    }


    public void deleteAlbum(String id) {
          albumRepository.deleteById(id);
    }

    public Album getAlbumById(String id) {
        return albumRepository.findById(id).get();
    }

}
