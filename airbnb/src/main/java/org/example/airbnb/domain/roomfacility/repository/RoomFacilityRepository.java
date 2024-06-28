package org.example.airbnb.domain.roomfacility.repository;

import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {
}
