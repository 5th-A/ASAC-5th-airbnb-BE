package org.example.airbnb.domain.roomfacility.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.room.entity.Room;

@Entity
@Getter
@NoArgsConstructor
public class RoomFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID")
    Facility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    Room room;
}
