package com.nana.usermanagementsystem.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="users_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String middleName;
    private String gender;
    private String email;
    private String phoneNumber;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Contact> contacts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
