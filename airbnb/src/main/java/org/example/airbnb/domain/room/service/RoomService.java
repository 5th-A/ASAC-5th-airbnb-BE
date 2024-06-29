package org.example.airbnb.domain.room.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.airbnb.domain.category.dto.CategoryResponseDto;
import org.example.airbnb.domain.category.entity.Category;
import org.example.airbnb.domain.category.repository.CategoryRepository;
import org.example.airbnb.domain.category.service.CategoryService;
import org.example.airbnb.domain.comment.repository.CommentRepository;
import org.example.airbnb.domain.facility.dto.FacilityResponseDto;
import org.example.airbnb.domain.facility.dto.RoomFacilityResponseDto;
import org.example.airbnb.domain.facility.entity.Facility;
import org.example.airbnb.domain.facility.repository.FacilityRepository;
import org.example.airbnb.domain.facility.service.FacilityService;
import org.example.airbnb.domain.image.dto.ImageDto;
import org.example.airbnb.domain.image.dto.MainRoomImageResponseDto;
import org.example.airbnb.domain.image.entity.Image;
import org.example.airbnb.domain.image.repository.ImageRepository;
import org.example.airbnb.domain.room.dto.RoomImageDto;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.domain.roomfacility.entity.RoomFacility;
import org.example.airbnb.domain.roomfacility.repository.RoomFacilityRepository;
import org.example.airbnb.exception.CustomRuntimeException;
import org.example.airbnb.exception.RoomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private final CategoryService categoryService;
    private final FacilityService facilityService;

    public List<RoomImageDto> getRoomWithImages(Pageable pageable){
        Page<Room> rooms = roomRepository.findAll(pageable);
        List<RoomImageDto> roomImageDtos = new ArrayList<>();

        for(Room room : rooms){
            List<Image> roomImages = imageRepository.findRoomByImage(room.getId());

            roomImageDtos.add(RoomImageDto.of(room, roomImages));
        }
        return roomImageDtos;
    }

    public RoomResponseDto findRoom(Long id){
        Room room = roomRepository.findById(id).orElseThrow( () -> {
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

    public MainRoomImageResponseDto findRoomImageByroomId(Long roomId) {
        try{
            Room room = roomRepository.findById(roomId).orElse(null);
            String roomName = room.getName();
            List<Image> images = imageRepository.findRoomByroomId(roomId);
            List<ImageDto> imageDtos = images.stream().map(ImageDto::of).collect(Collectors.toList());

            MainRoomImageResponseDto mainRoomImageResponseDto = MainRoomImageResponseDto.of(roomName, imageDtos);
            return mainRoomImageResponseDto;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public RoomFacilityResponseDto findFacilitiesByroomId(Long roomId) {
        List<RoomFacility> roomFacilities = roomFacilityRepository.findAll();
        for(RoomFacility roomFacility : roomFacilities){
            Long id = roomFacility.getId();
            if(id.equals(roomId)){
                List<Facility> facilities = facilityRepository.findAll();
                List<FacilityResponseDto> facilityResponseDtoList = facilities.stream()
                        .map(FacilityResponseDto::of)
                        .collect(Collectors.toList());
                RoomFacilityResponseDto roomFacilityResponseDto = RoomFacilityResponseDto.of(facilityResponseDtoList);
                return roomFacilityResponseDto;
            }
        }
        return null;
    }
}
