package org.example.airbnb.domain.room.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.room.entity.Room;

import java.util.List;

@Getter
@AllArgsConstructor
public class RoomResponseDto {
    private final Long id;
    private final String address;
    private final String roomType;
    private final Boolean guestPrefer;
    private final Long price;
    private final Integer maximum;
    private final Integer beds;
    private final Integer bedRooms;
    private final Integer bathRooms;
    private final CategoryResponseDto category;
    private final List<FacilityResponseDto> facilities;

    public static RoomResponseDto of(Room room, CategoryResponseDto categoryDto, List<FacilityResponseDto> facilityResponseDto) {
        return new RoomResponseDto(
                room.getId(),
                room.getAddress(),
                room.getRoomType(),
                room.getGuestPrefer(),
                room.getPrice(),
                room.getMaxGuest(),
                room.getBed(),
                room.getBedroom(),
                room.getBathroom(),
                categoryDto,
                facilityResponseDto
        );
    }
}