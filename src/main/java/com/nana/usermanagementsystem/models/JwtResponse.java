package com.nana.usermanagementsystem.models;

import com.nana.usermanagementsystem.entities.Role;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> roles;


    public JwtResponse(){

    }

    public JwtResponse(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
