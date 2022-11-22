package com.example.assignment6.resource;



import com.example.assignment6.exception.RestrictedInfoException;
import com.example.assignment6.model.User;
import com.example.assignment6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    //POST  methods
    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/find")
    public User getUserByID(@RequestParam("id")String id){
        return userService.getUserById(id);
    }

    @GetMapping("/find-by-name")
    public List<User> getByName(@RequestParam(name = "name")String name) throws RestrictedInfoException {
        if (name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getByName(name);
    }


    //PUT methods
    @PutMapping
    public User updateUser( @RequestBody User user){
        return userService.updateUser(user);
    }

    //DELETE methods
    @DeleteMapping
    public void deleteUser (@RequestParam(name = "id")String id){
         userService.deleteUser(id);
    }

}
