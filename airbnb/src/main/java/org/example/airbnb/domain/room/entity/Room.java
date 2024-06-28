package org.example.airbnb.domain.room.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.category.entity.Category;
import org.example.airbnb.domain.city.entity.City;
import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.user.entity.User;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "BEDROOM")
    private Integer bedroom;
    @Column(name = "BED")
    private Integer bed;
    @Column(name = "BATHROOM")
    private Integer bathroom;
    @Column(name = "MAX_GUEST")
    private Integer maxGuest;
    @Column(name = "CHECK_IN")
    private LocalDate checkIn;
    @Column(name = "CHECK_OUT")
    private LocalDate checkOut;
    @Column(name = "GUEST_PREFER")
    private Boolean guestPrefer;
    @Column(name = "DESCRIPTION")
    private String DESCRIPTION;
    @Column(name = "COMMENT_COUNT")
    private Integer commentCount;
    @Column(name = "TOTAL_RATE")
    private Integer totalRate;
    @Column(name = "ROOM_TYPE")
    private String roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private City city;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
