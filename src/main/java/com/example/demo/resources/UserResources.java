/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/users")
public class UserResources {
    
    @Autowired
    private UserService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        
        List<User> lista = service.findAll();
        List<UserDTO> listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
               
        return ResponseEntity.ok().body(listaDTO);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        
        User user = service.findById(id);
       
        return ResponseEntity.ok().body(new UserDTO(user));
    }
    
    @RequestMapping(value="/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        
        User user = service.findById(id);
       
        return ResponseEntity.ok().body(user.getPosts());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> findById(@RequestBody UserDTO userdto){
        
        User user = service.fromDTO(userdto);
        user = service.insert(user);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteById(@RequestBody UserDTO userDto, @PathVariable String id){
        
        User user = service.fromDTO(userDto);
        user.setId(id);
        service.update(user);
        
        return ResponseEntity.noContent().build();
    }
}
