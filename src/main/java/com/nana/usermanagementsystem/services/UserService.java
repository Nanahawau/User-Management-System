package com.nana.usermanagementsystem.services;

import com.nana.usermanagementsystem.entities.Contact;
import com.nana.usermanagementsystem.entities.Role;
import com.nana.usermanagementsystem.entities.User;
import com.nana.usermanagementsystem.models.LoginDTO;
import com.nana.usermanagementsystem.models.RegisterDTO;
import com.nana.usermanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    public ResponseEntity<?> register (RegisterDTO registerDTO) {
        User user = new User();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>(registerDTO.getRole()));
        user.setContacts(Collections.singletonList(new Contact(registerDTO.getAddressName(), registerDTO.getState()
                , registerDTO.getCountry(), registerDTO.getPhoneNumber())));
        User userObject = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userObject.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    public ResponseEntity<?> resetPassword (String email) {
        return ResponseEntity.accepted().build();
    }

    public ResponseEntity<?> updatePassword  (LoginDTO loginDTO) {
        return ResponseEntity.noContent().build();
    }



    public void saveToken (User user, String token){
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 12); // adds one hour
        Date expiryDate = cal.getTime();

        System.out.println("<<<<<<<<<<<< from create token"+user);

        Token newToken = new Token(token, user, expiryDate);

        tokenDAO.save(newToken);

    }


    public String generateToken (){
       return UUID.randomUUID().toString();
    }


}
