package com.nana.usermanagementsystem.controllers;

import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.Response;
import com.nana.usermanagementsystem.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ums/v1")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public Response login (@RequestBody User user){
        return authenticationService.authenticate(user);
    }

    @PostMapping("/register")
    public Response register (@RequestBody User user) {
        return authenticationService.register(user);
    }
}
