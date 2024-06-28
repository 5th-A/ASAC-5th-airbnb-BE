package org.example.airbnb.domain.facility.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class RoomFacilityResponseDto {
    private List<FacilityResponseDto> roomFacilities;

    public static RoomFacilityResponseDto of(List<FacilityResponseDto> facilities){
        return RoomFacilityResponseDto.builder()
                .roomFacilities(facilities)
                .build();
    }
    @Builder
    private RoomFacilityResponseDto(List<FacilityResponseDto> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }
}
