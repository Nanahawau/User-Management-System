package com.nana.usermanagementsystem.controllers;

import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.Response;
import com.nana.usermanagementsystem.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ums/api/v1/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public Response login (@RequestBody User user){
        return authenticationService.authenticate(user);
    }
}
