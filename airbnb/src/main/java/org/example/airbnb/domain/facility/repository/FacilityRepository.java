package org.example.airbnb.domain.facility.repository;

import org.example.airbnb.domain.facility.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
}
