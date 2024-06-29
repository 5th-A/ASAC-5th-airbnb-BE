package org.example.airbnb.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.user.entity.User;

@NoArgsConstructor
@Getter
public class RoomDto {
    private Long id;
    private String address;
    private String roomType;
    private Boolean guestPrefer;
    private Long price;
    private Integer maximum;
    private Integer beds;
    private Integer bedRooms;
    private Integer bathRooms;
    private User user;

    public static RoomDto from(Room room){
        return RoomDto.builder()
                .id(room.getId())
                .address(room.getAddress())
                .roomType(room.getRoomType())
                .guestPrefer(room.getGuestPrefer())
                .price(room.getPrice())
                .maximum(room.getMaxGuest())
                .beds(room.getBed())
                .bedRooms(room.getBedroom())
                .bathRooms(room.getBathroom())
                .user(room.getUser())
                .build();
    }

    @Builder
    private RoomDto(Long id, String address, String roomType, Boolean guestPrefer, Long price, Integer maximum, Integer beds, Integer bedRooms, Integer bathRooms, User user) {
        this.id = id;
        this.address = address;
        this.roomType = roomType;
        this.guestPrefer = guestPrefer;
        this.price = price;
        this.maximum = maximum;
        this.beds = beds;
        this.bedRooms = bedRooms;
        this.bathRooms = bathRooms;
        this.user = user;
    }
}
