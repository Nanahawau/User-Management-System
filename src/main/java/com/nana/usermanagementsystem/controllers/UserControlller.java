package com.nana.usermanagementsystem.controllers;

import com.nana.usermanagementsystem.models.LoginDTO;
import com.nana.usermanagementsystem.models.RegisterDTO;
import com.nana.usermanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ums/v1")
public class UserControlller {

    @Autowired
    UserService userService;


    @PostMapping("user/register")
    public ResponseEntity<?> register (@RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @PutMapping("user/password/reset")
    public ResponseEntity<?> resetPassword(@RequestBody String email) {
        return userService.resetPassword(email);
    }

    @PutMapping("user/password/update")
    public ResponseEntity<?> updatePassword (@RequestBody LoginDTO loginDTO) {
        return userService.updatePassword(loginDTO);
    }

}
