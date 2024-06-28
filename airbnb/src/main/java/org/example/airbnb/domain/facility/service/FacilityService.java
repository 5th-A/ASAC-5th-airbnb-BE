package org.example.airbnb.domain.facility.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.facility.repository.FacilityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityRepository facilityRepository;
}
