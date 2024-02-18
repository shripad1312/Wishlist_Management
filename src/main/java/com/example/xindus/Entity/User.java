package com.example.xindus.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique=true,nullable = false)
    private String username;

    private String password;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cart> cartItems = new ArrayList<>();




}
