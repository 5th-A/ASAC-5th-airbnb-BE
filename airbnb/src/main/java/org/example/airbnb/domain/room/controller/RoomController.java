package org.example.airbnb.domain.room.controller;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.comment.dto.CommentDto;
import org.example.airbnb.domain.comment.dto.CommentRequestDto;
import org.example.airbnb.domain.comment.dto.CommentResponseDto;
import org.example.airbnb.domain.comment.service.CommentService;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.facility.dto.RoomFacilityResponseDto;
import org.example.airbnb.domain.image.dto.MainRoomImageResponseDto;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.service.RoomService;
import org.example.airbnb.domain.user.dto.MainHostResponseDto;
import org.example.airbnb.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    private final UserService userService;
    private final CommentService commentService;

    // 메인 룸 이미지
    @GetMapping("/{roomId}/images")
    public ResponseEntity<MainRoomImageResponseDto> getRoomImages(@PathVariable Long roomId) {
        MainRoomImageResponseDto roomImagesByRoomId = roomService.findRoomImageByRoomId(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(roomImagesByRoomId);
    }

    // 메인 룸정보
    @GetMapping("/{roomId}")
    public ResponseEntity<RoomResponseDto> getRoom(@PathVariable Long roomId) {
        RoomResponseDto room = roomService.findRoom(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    // 메인 호스트 정보
    @GetMapping("/{roomId}/user/{userId}")
    public ResponseEntity<MainHostResponseDto> getRoomByUserId(@PathVariable Long roomId, @PathVariable Long userId) throws SQLException {
        MainHostResponseDto mainHostResponseDto = userService.findRoomById(roomId, userId);
        return ResponseEntity.status(HttpStatus.OK).body(mainHostResponseDto);
    }

    // 숙소 편의시설
    @GetMapping("/{roomId}/facilities")
    public ResponseEntity<RoomFacilityResponseDto> getFacilitiesByRoomId(@PathVariable Long roomId) {
        RoomFacilityResponseDto roomFacilityResponseDto = roomService.findFacilitiesByRoomId(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(roomFacilityResponseDto);
    }

    // 댓글 출력
    @GetMapping("/{roomId}/comments")
    public ResponseEntity<CommentResponseDto> getComments(@PathVariable Long roomId) {
        CommentResponseDto commentResponseDto = commentService.findCommentByRoomId(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(commentResponseDto);
    }

    // 댓글 입력
    @PostMapping("/{roomId}/comment")
    public ResponseEntity<CommentDto> setComment(@PathVariable Long roomId, @RequestBody CommentRequestDto commentRequestDto) {
        CommentDto commentDto = commentService.saveComment(roomId, commentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDto);
    }
}
