package com.codeup.codeupspringblogexercises.repositories;



import com.codeup.codeupspringblogexercises.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findAll();
   void deleteById(long id);
   Post getById(long id);
   //     List<Post> findByBodyContaining(String body); 
//    List<Post> findByTitleContaining(String title);
}
