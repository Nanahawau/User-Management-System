package com.nana.usermanagementsystem.entities;

import com.nana.usermanagementsystem.models.Auditable;
import com.nana.usermanagementsystem.models.ERole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "roles")
public class Role extends Auditable<String> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="roles_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }


}