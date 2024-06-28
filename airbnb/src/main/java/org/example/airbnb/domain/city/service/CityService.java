package org.example.airbnb.domain.city.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.city.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
}
