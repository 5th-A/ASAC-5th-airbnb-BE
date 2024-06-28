package org.example.airbnb.domain.facility.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.facility.repository.FacilityRepository;
import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.example.airbnb.domain.roomfacility.repository.RoomFacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final RoomFacilityRepository roomFacilityRepository;

    public List<FacilityResponseDto> getFacilitiesByRoom(Room room) {
        List<RoomFacility> roomFacilities = roomFacilityRepository.findByRoomId(room.getId());
        return roomFacilities.stream()
                .map(roomFacility->
                    FacilityResponseDto.of(roomFacility.getFacility())
                )
                .collect(Collectors.toList());
    }
}
