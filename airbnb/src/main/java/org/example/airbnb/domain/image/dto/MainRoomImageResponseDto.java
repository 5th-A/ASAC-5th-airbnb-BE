package org.example.airbnb.domain.image.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class MainRoomImageResponseDto {
    @JsonProperty(value = "RoomName")
    private String roomName;
    @JsonProperty(value = "RoomImages")
    private List<ImageDto> RoomImages;


    public static MainRoomImageResponseDto of(String roomName, List<ImageDto> imageDtoList){
        return MainRoomImageResponseDto.builder()
                .roomName(roomName)
                .roomImages(imageDtoList)
                .build();
    }

    @Builder
    private MainRoomImageResponseDto(String roomName, List<ImageDto> roomImages) {
        this.roomName = roomName;
        this.RoomImages = roomImages;
    }
}
