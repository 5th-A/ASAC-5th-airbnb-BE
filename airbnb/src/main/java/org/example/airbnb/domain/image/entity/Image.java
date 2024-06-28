package org.example.airbnb.domain.image.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.room.entity.Room;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="IMAGE_URL")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;
}
