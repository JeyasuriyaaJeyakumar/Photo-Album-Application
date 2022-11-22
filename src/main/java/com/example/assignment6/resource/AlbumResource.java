package com.example.assignment6.resource;


import com.example.assignment6.model.Album;
import com.example.assignment6.model.FirebaseUser;
import com.example.assignment6.service.AlbumService;
import com.example.assignment6.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/albums")

public class AlbumResource {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private FirebaseService firebaseService;

    //POST  methods
    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            return albumService.saveAlbum(album);
        }
        return null;
    }
    @GetMapping
    public List<Album> getAllAlbum(){
        return albumService.getAllAlbum();
    }

    @GetMapping("/find")
    public Album getAlbumByID(@RequestParam("id")String id){
        return albumService.getAlbumById(id);
    }

    //PUT methods
    @PutMapping
    public Album updateAlbum(@RequestBody Album album, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            return albumService.updateAlbum(album);
        }
        return null;
    }

    //DELETE methods
    @DeleteMapping
    public void deleteAlbum(@RequestParam("id")String id, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            albumService.deleteAlbum(id);
        }
    }
}
