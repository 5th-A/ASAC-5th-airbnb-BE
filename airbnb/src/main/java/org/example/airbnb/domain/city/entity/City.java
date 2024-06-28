package org.example.airbnb.domain.city.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.airbnb.domain.country.entity.Country;

@Entity
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
}
