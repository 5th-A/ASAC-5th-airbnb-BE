package org.example.airbnb.domain.room.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.category.entity.Category;
import org.example.airbnb.domain.category.repository.CategoryRepository;
import org.example.airbnb.domain.comment.repository.CommentRepository;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.facility.dto.RoomFacilityResponseDto;
import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.facility.repository.FacilityRepository;
import org.example.airbnb.domain.image.dto.ImageDto;
import org.example.airbnb.domain.image.dto.MainRoomImageResponseDto;
import org.example.airbnb.domain.image.entity.Image;
import org.example.airbnb.domain.image.repository.ImageRepository;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.example.airbnb.domain.roomfacility.repository.RoomFacilityRepository;
import org.example.airbnb.exception.CustomRuntimeException;
import org.example.airbnb.exception.FacilityException;
import org.example.airbnb.exception.RoomException;
import org.example.airbnb.exception.RoomFacilityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {
    private final RoomRepository roomRepository;
    private final CommentRepository commentRepository;
    private final FacilityRepository facilityRepository;
    private final ImageRepository imageRepository;
    private final RoomFacilityRepository roomFacilityRepository;

    public RoomResponseDto findRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> {
            throw new CustomRuntimeException(RoomException.ROOM_NOT_FOUND_EXCEPTION);
        });

        Category category = room.getCategory();
        List<Facility> facilityList = facilityRepository.findAll();

        List<FacilityResponseDto> facilityResponseDtoList = facilityList
                .stream()
                .map(FacilityResponseDto::of)
                .collect(Collectors.toList());

        CategoryResponseDto categoryResponseDto = CategoryResponseDto.of(category);
        RoomResponseDto roomResponseDto = RoomResponseDto.of(room, categoryResponseDto, facilityResponseDtoList);
        return roomResponseDto;
    }

    public MainRoomImageResponseDto findRoomImageByRoomId(Long roomId) {
        try {
            Room room = roomRepository.findById(roomId).orElse(null);
            String roomName = room.getName();
            List<Image> images = imageRepository.findRoomByRoomId(roomId);
            List<ImageDto> imageDtos = images.stream().map(ImageDto::of).collect(Collectors.toList());

            MainRoomImageResponseDto mainRoomImageResponseDto = MainRoomImageResponseDto.builder()
                    .roomName(roomName)
                    .roomImages(imageDtos)
                    .build();
            return mainRoomImageResponseDto;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public RoomFacilityResponseDto findFacilitiesByRoomId(Long roomId) {
        List<RoomFacility> roomFacilities = roomFacilityRepository.findFacilitiesByroomId(roomId);
        if (roomFacilities.isEmpty()) {
            throw new CustomRuntimeException(RoomFacilityException.ROOM_FACILITY_NOT_FOUND_EXCEPTION);
        }

        List<FacilityResponseDto> facilities = roomFacilities.stream()
                .map(roomFacility -> facilityRepository.findById(roomFacility.getFacility().getId())
                        .orElseThrow(() -> new CustomRuntimeException(FacilityException.FACILITY_NOT_FOUND_EXCEPTION)))
                .map(FacilityResponseDto::of)
                .collect(Collectors.toList());

        return RoomFacilityResponseDto.of(facilities);
    }
}
