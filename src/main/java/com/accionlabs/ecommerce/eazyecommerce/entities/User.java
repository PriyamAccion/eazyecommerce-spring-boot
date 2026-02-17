package com.accionlabs.ecommerce.eazyecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

}
