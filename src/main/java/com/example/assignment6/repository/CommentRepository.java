package com.example.assignment6.repository;


import com.example.assignment6.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllById(String id);

    List<Comment> findByPhotoId(String photoId);
}
