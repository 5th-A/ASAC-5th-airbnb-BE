package org.example.airbnb.domain.room.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.airbnb.domain.image.dto.ImageDto;
import org.example.airbnb.domain.image.entity.Image;
import org.example.airbnb.domain.room.entity.Room;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class RoomImageDto {
    private Long id;
    private String address;
    private Long price;
    private String date;
    private List<ImageDto> roomImages;
    private Boolean isLike;
    private Boolean guestPrefer;
    private Integer rate;

    public static RoomImageDto of(Room room, List<Image> roomImages){
        String date = room.getCheckIn().toString() + " ~ " + room.getCheckOut().toString();

        List<ImageDto> imageDtos = roomImages.stream()
                .map(ImageDto::of)
                .collect(Collectors.toList());

        return RoomImageDto.builder()
                .id(room.getId())
                .address(room.getAddress())
                .price(room.getPrice())
                .date(date)
                .roomImages(imageDtos)
                .isLike(false)
                .guestPrefer(room.getGuestPrefer())
                .rate(room.getTotalRate())
                .build();
    }

    @Builder
    public RoomImageDto(Long id, String address, Boolean guestPrefer, Long price, String date, List<ImageDto> roomImages, Boolean isLike, Integer rate) {
        this.id = id;
        this.address = address;
        this.guestPrefer = guestPrefer;
        this.price = price;
        this.date = date;
        this.roomImages = roomImages;
        this.isLike = isLike;
        this.rate = rate;
    }
}
