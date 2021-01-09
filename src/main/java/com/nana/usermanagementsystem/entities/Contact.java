package com.nana.usermanagementsystem.entities;

import com.nana.usermanagementsystem.models.Auditable;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "contacts")
public class Contact extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contacts_seq")
    private Long id;
    @NonNull
    private String addressName;
    @NonNull
    private String state;
    @NonNull
    private String country;
    @NonNull
    private String phoneNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
