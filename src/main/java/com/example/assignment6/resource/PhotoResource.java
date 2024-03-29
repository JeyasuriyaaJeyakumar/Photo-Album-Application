package com.example.assignment6.resource;



import com.example.assignment6.exception.RestrictedInfoException;
import com.example.assignment6.model.Album;
import com.example.assignment6.model.FirebaseUser;
import com.example.assignment6.model.Photo;
import com.example.assignment6.model.User;
import com.example.assignment6.service.FirebaseService;
import com.example.assignment6.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotoResource {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private FirebaseService firebaseService;

    //POST  methods
    @PostMapping
    public Photo savePhoto(@RequestBody @Valid Photo photo){
        return photoService.savePhoto(photo);
    }
    @GetMapping
    public List<Photo> getAllPhoto(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            return photoService.getAllPhoto();
        }
        return null;
    }

    @GetMapping("/find")
    public Photo getPhotoById(@RequestParam(value = "id")String id){
        return photoService.getPhotoById(id);
    }
    @GetMapping("/find/{id}/photo")
    @ResponseBody
    public List<Photo> getPhotoByPhotoId(@PathVariable(name = "id")String id, @RequestHeader(name = "idToken") String idToken) throws RestrictedInfoException, IOException, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            if (id.equalsIgnoreCase("root")){
                throw new RestrictedInfoException();
            }
            return photoService.getPhotoByPhotoId(id);
        }
        return null;
    }



   @GetMapping("/find/{albumId}")
    public List<Photo> getPhotoByAlbumId(@PathVariable(name = "albumId")String albumId) throws RestrictedInfoException {
        if (albumId.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return photoService.getPhotoByAlbumId(albumId);
    }

    //PUT methods
    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }
    //DELETE methods
    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "id")String id){
          photoService.deletePhoto(id);
    }

}
