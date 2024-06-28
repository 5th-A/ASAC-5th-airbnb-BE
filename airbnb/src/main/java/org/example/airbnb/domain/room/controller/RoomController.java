package org.example.airbnb.domain.room.controller;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.facility.dto.RoomFacilityResponseDto;
import org.example.airbnb.domain.image.dto.MainRoomImageResponseDto;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.service.RoomService;
import org.example.airbnb.domain.user.dto.MainHostResponseDto;
import org.example.airbnb.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    private final UserService userService;

    // 메인 룸 이미지
    @GetMapping("/{roomId}/images")
    public ResponseEntity<MainRoomImageResponseDto> getRoomImages(@PathVariable Long roomId){
        MainRoomImageResponseDto roomImageByroomId = roomService.findRoomImageByroomId(roomId);
        return roomImageByroomId != null ?
                ResponseEntity.status(HttpStatus.OK).body(roomImageByroomId) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
        return mainHostResponseDto != null ?
                ResponseEntity.status(HttpStatus.OK).body(mainHostResponseDto) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // 숙소 편의시설
    @GetMapping("/{roomId}/facilities")
    public ResponseEntity<RoomFacilityResponseDto> getFacilitiesByRoomId(@PathVariable Long roomId){
        RoomFacilityResponseDto roomFacilityResponseDto = roomService.findFacilitiesByroomId(roomId);
        return roomFacilityResponseDto != null ?
                ResponseEntity.status(HttpStatus.OK).body(roomFacilityResponseDto) :
                ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
    }
}
