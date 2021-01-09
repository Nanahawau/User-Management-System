package com.nana.usermanagementsystem.controllers;

import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.JwtResponse;
import com.nana.usermanagementsystem.models.LoginDTO;
import com.nana.usermanagementsystem.models.RegisterDTO;
import com.nana.usermanagementsystem.models.Response;
import com.nana.usermanagementsystem.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ums/v1")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("auth/login")
    public ResponseEntity<JwtResponse> login (@RequestBody User user) throws Exception {
        return authenticationService.authenticate(user);
    }


}
