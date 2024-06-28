package org.example.airbnb.domain.country.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
}
