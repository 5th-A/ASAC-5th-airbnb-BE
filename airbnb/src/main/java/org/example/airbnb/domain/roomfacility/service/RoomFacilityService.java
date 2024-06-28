package org.example.airbnb.domain.roomfacility.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.roomfacility.repository.RoomFacilityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomFacilityService {
    private final RoomFacilityRepository roomFacilityRepository;
}
