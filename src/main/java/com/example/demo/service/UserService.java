/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {

        return repo.findAll();
    }

    public User findById(String id) {
        
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    
    }
    
    public User insert(User user) {
        return repo.insert(user);
    
    }
    
    public void delete(String id) {
 
        findById(id);
        repo.deleteById(id);
    
    }
    
    public User fromDTO(UserDTO obj){     
        return new User(obj.getId(), obj.getName(), obj.getEmail());   
    }
}
