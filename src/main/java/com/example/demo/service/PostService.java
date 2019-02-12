/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.exception.ObjectNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {

        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));

    }
    
    public List<Post> findByText(String text){
        
        return repo.searchText(text);
        
    }
    
    public List<Post> fullSearch(String text, Date dateMin, Date DateMax){
        
        DateMax = new Date(DateMax.getTime()+24*60*60*1000);
        return repo.fullSearch(text, dateMin, DateMax);
        
    }
 
}
