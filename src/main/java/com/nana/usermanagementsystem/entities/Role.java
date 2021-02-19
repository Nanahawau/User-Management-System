package com.nana.usermanagementsystem.entities;

import com.nana.usermanagementsystem.models.Auditable;
import com.nana.usermanagementsystem.models.ERole;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "roles")
public class Role extends Auditable<String> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="roles_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @NonNull
    private String name;







}