/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.config;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author andre
 */
@Configuration
public class UserInstantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
     @Autowired
    private PostRepository postRepository;
     
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();
        
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        
        Post post1 = new Post(null, date.parse("22/01/1992") , "Título 1", "Vou viajar amanha", new AuthorDTO(maria));
        Post post2 = new Post(null, date.parse("23/01/1992") , "Título 2", "Corpo da mensagem 2", new AuthorDTO(maria));
        Post post3 = new Post(null, date.parse("25/01/1992") , "Título 3", "Corpo da mensagem 3", new AuthorDTO(bob));
        Post post4 = new Post(null, date.parse("25/01/1992") , "bom dia", "Corpo da mensagem 4", new AuthorDTO(alex));
              
        CommentDTO comment1 = new CommentDTO("Boa viajem Maria", date.parse("25/01/1993"), new AuthorDTO(bob));
        CommentDTO comment2 = new CommentDTO("vai e nao volta mais", date.parse("26/01/1993"), new AuthorDTO(alex));
        post1.setComments(Arrays.asList(comment1,comment2));
        
        postRepository.saveAll(Arrays.asList(post1,post2,post3,post4));
        
        maria.setPosts(Arrays.asList(post1,post2));
        bob.setPosts(Arrays.asList(post3));
        alex.setPosts(Arrays.asList(post4));
        
        userRepository.saveAll(Arrays.asList(maria,bob));
        
    }

}
