package org.example.airbnb.domain.image.repository;

import org.example.airbnb.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    @Query("SELECT I FROM Image I WHERE I.room.id = :roomId")
    List<Image> findRoomByRoomId(Long roomId);
}
