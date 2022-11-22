package com.example.assignment6.repository;




import com.example.assignment6.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByName(String name);

}
