package org.example.airbnb.domain.roomfacility.repository;

import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {
    @Query("SELECT RF FROM RoomFacility RF WHERE RF.room.id = :roomId")
    List<RoomFacility> findFacilitiesByroomId(Long roomId);

}
