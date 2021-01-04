package com.nana.usermanagementsystem.entities;

import com.nana.usermanagementsystem.models.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "contacts")
public class Contact extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contacts_seq")
    private Long id;
    private String addressName;
    private String state;
    private String country;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
