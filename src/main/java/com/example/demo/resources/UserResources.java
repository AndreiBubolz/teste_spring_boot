/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        
        List<User> lista = service.findAll();
        
        return ResponseEntity.ok().body(lista);
    }
    
}
