package com.example.assignment6.resource;


import com.example.assignment6.model.Album;
import com.example.assignment6.model.FirebaseUser;
import com.example.assignment6.service.AlbumService;
import com.example.assignment6.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
@CrossOrigin(origins = "http://localhost:4200")


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
    @PutMapping("/albumCover")
    @CrossOrigin
    public ResponseEntity<Album> updateAlbumCover(@RequestHeader("idToken") String idToken,@RequestParam String id, @RequestParam String coverPhotoUrl)
            throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            Album album = albumService.getAlbumById(id);
            album.setCoverPhotoUrl(coverPhotoUrl);
            return new ResponseEntity<>(albumService.saveAlbum(album), HttpStatus.OK);
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
