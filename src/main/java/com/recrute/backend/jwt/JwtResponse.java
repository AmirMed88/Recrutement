package com.recrute.backend.jwt;

import java.util.List;

public class JwtResponse {
    private String token;
    private Long id;
    private String username;
    private List<String> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, Long id, String username, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public JwtResponse token(String token) {
        setToken(token);
        return this;
    }

    public JwtResponse id(Long id) {
        setId(id);
        return this;
    }

    public JwtResponse username(String username) {
        setUsername(username);
        return this;
    }

    public JwtResponse roles(List<String> roles) {
        setRoles(roles);
        return this;
    }
    
}
