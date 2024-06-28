package org.example.airbnb.domain.comment.repository;

import org.example.airbnb.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM COMMENT WHERE ROOM_ID = :roomId", nativeQuery = true)
    List<Comment> findCommentByRoomId(Long roomId);
    @Query(value = "SELECT ROUND(AVG(RATE),2) FROM COMMENT WHERE ROOM_ID = :roomId",nativeQuery = true)
    Double findTotalAvg(Long roomId);
}
