package com.nana.usermanagementsystem.entities;

import com.nana.usermanagementsystem.models.Auditable;
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
@Entity
public class User extends Auditable<String> {
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


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Contact> contacts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
