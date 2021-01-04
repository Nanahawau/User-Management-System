package com.nana.usermanagementsystem.services;

import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.JwtResponse;
import com.nana.usermanagementsystem.models.Response;
import com.nana.usermanagementsystem.repositories.RoleRepository;
import com.nana.usermanagementsystem.repositories.UserRepository;
import com.nana.usermanagementsystem.security.jwt.JwtUtils;
import com.nana.usermanagementsystem.security.services.UserDetailsImplementation;
import liquibase.pro.packaged.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public Response authenticate(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new Response("000", "Login was successful",
                new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles));
    }


    public Response register (User user) {
        System.out.println("password" + user.getPassword());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return new Response("000", "Sucess", "");
    }


}

