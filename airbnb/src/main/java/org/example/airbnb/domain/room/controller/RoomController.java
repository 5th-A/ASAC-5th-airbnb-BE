package org.example.airbnb.domain.room.controller;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.facility.dto.RoomFacilityResponseDto;
import org.example.airbnb.domain.image.dto.MainRoomImageResponseDto;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.service.RoomService;
import org.example.airbnb.domain.user.dto.MainHostResponseDto;
import org.example.airbnb.domain.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    // 숙소 목록 출력
    @GetMapping
    public ResponseEntity<Page<RoomResponseDto>> getRoomList(
            @RequestParam(value="categoryId", required = false) Long categoryId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "1") int size
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Page<RoomResponseDto> roomList = roomService.findRoomIdList(pageable);
        return ResponseEntity.ok(roomList);
    }

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
