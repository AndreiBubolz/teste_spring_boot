/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources;

import com.example.domain.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/users")
public class UserResources {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        
        User a = new User("1", "maria", "maria@gmail.com");
        User b = new User("2", "joao", "joao@gmail.com");
        
        List<User> lista = new ArrayList();
        
        lista.addAll(Arrays.asList(a,b));
        
        return ResponseEntity.ok().body(lista);
    }
    
}
