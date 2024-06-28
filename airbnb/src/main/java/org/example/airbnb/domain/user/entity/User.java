package org.example.airbnb.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.airbnb.domain.country.entity.Country;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME" , length = 20)
    private String name;
    @Column(name = "PROFILE", length = 3000)
    private String profile;
    @Column(name = "REG_DATE")
    private LocalDate regDate;
    @Column(name = "SUPERHOST")
    private Boolean superhost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
}
