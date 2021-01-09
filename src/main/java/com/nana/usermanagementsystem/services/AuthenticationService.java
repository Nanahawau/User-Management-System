package com.nana.usermanagementsystem.services;

import com.nana.usermanagementsystem.entities.Contact;
import com.nana.usermanagementsystem.entities.Role;
import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.*;
import com.nana.usermanagementsystem.repositories.RoleRepository;
import com.nana.usermanagementsystem.repositories.UserRepository;
import com.nana.usermanagementsystem.security.jwt.JwtUtils;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.util.*;
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

    @Autowired
    MailService mailService;

    @Autowired
    com.nana.usermanagementsystem.security.services.UserDetailsServiceImplementation UserDetailsServiceImplementation;

    public ResponseEntity<JwtResponse> authenticate(User user) throws Exception {

        authenticate(user.getUsername(), user.getPassword());

        final UserDetails userDetails = UserDetailsServiceImplementation.loadUserByUsername(user.getUsername());

        final String token = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername(), roles));


    }




    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }




}

