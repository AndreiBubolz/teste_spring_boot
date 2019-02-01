/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources.exceptions;

import com.example.demo.service.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author andre
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        
        HttpStatus status  = HttpStatus.NOT_FOUND;
        
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), request.getRequestURI(), "Não encontrado", e.getMessage());
        
        return ResponseEntity.status(status).body(err);
        
    }
    
}
