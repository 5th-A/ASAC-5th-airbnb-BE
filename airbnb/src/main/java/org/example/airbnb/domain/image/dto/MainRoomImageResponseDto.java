package org.example.airbnb.domain.image.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
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
    private List<ImageDto> roomImages;

    @Builder
    private MainRoomImageResponseDto(String roomName, List<ImageDto> roomImages) {
        this.roomName = roomName;
        this.roomImages = roomImages;
    }
}