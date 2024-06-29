package org.example.airbnb.domain.facility.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RoomFacilityResponseDto {
    private final List<FacilityResponseDto> roomFacilities;

    public static RoomFacilityResponseDto of(List<FacilityResponseDto> facilities){
        return new RoomFacilityResponseDto(
                facilities
        );
    }
}
