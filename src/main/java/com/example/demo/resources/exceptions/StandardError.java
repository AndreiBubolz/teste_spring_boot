/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.resources.exceptions;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long timestamp;
    private Integer status;
    private String path;
    private String message;
    private String error;

    public StandardError() {
    }

    public StandardError(Long timestamp, Integer status, String path, String message, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.message = message;
        this.error = error;
    }

    
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    
}
