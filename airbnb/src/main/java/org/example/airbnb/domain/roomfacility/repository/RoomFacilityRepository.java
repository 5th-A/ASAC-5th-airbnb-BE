package org.example.airbnb.domain.roomfacility.repository;

import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {

    List<RoomFacility> findByRoomId(Long roomId);
}

