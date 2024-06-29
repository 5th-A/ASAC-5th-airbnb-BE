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
        return RoomResponseDto.builder()
                .id(room.getId())
                .address(room.getAddress())
                .roomType(room.getRoomType())
                .guestPrefer(room.getGuestPrefer())
                .price(room.getPrice())
                .maximum(room.getMaxGuest())
                .beds(room.getBed())
                .bedRooms(room.getBedroom())
                .bathRooms(room.getBathroom())
                .category(categoryDto)
                .facilityListResponseDto(facilityResponseDto)
                .build();
    }

    @Builder
    private RoomResponseDto(Long id, String address, String roomType, Boolean guestPrefer, Long price, Integer maximum, Integer beds, Integer bedRooms, Integer bathRooms, CategoryResponseDto category, List<FacilityResponseDto> facilityListResponseDto) {
        this.id = id;
        this.address = address;
        this.roomType = roomType;
        this.guestPrefer = guestPrefer;
        this.price = price;
        this.maximum = maximum;
        this.beds = beds;
        this.bedRooms = bedRooms;
        this.bathRooms = bathRooms;
        this.category = category;
        this.facilities = facilityListResponseDto;
    }
}
