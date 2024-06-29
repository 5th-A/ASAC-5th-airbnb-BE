package org.example.airbnb.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.room.entity.Room;

import java.util.List;

@NoArgsConstructor
@Getter
public class RoomResponseDto {
    private Long id;
    private String address;
    private String roomType;
    private Boolean guestPrefer;
    private Long price;
    private Integer maximum;
    private Integer beds;
    private Integer bedRooms;
    private Integer bathRooms;
    private CategoryResponseDto category;
    private List<FacilityResponseDto> facilities;

    public static RoomResponseDto of(Room room, CategoryResponseDto categoryDto, List<FacilityResponseDto> facilityResponseDto) {
        RoomResponseDto dto = new RoomResponseDto();
        dto.id = room.getId();
        dto.address = room.getAddress();
        dto.roomType = room.getRoomType();
        dto.guestPrefer = room.getGuestPrefer();
        dto.price = room.getPrice();
        dto.maximum = room.getMaxGuest();
        dto.beds = room.getBed();
        dto.bedRooms = room.getBedroom();
        dto.bathRooms = room.getBathroom();
        dto.category = categoryDto;
        dto.facilities = facilityResponseDto;
        return dto;
    }
}
