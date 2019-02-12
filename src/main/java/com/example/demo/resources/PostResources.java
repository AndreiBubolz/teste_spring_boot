/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.resources.util.URL;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/posts")
public class PostResources {
    
    @Autowired
    private PostService service;
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        
        Post post = service.findById(id);
       
        return ResponseEntity.ok().body(post);
    }
    
    @RequestMapping(value="/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByText(@RequestParam(value="text", defaultValue ="") String text){
        
        text = URL.decodeParam(text);
        
        List<Post> posts = service.findByText(text);
       
        return ResponseEntity.ok().body(posts);
    }
    
    @RequestMapping(value="/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue ="") String text,
            @RequestParam(value="text", defaultValue ="") String dateMin,
            @RequestParam(value="text", defaultValue ="") String dateMax){
        
        text = URL.decodeParam(text);
        Date min = URL.convertDate(dateMin, new Date(0L));
        Date max = URL.convertDate(dateMax, new Date());
        
        List<Post> posts = service.fullSearch(text, min, max);
       
        return ResponseEntity.ok().body(posts);
    }
     
}
