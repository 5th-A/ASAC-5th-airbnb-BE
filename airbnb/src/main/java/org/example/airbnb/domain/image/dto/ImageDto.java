package org.example.airbnb.domain.image.dto;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.image.entity.Image;

import java.util.List;

@NoArgsConstructor
@Getter
public class ImageDto {
    private Long id;
    private String url;


    public static ImageDto of(Image image){
        return ImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .build();
    }

    @Builder
    public ImageDto(Long id, String imageUrl) {
        this.id = id;
        this.url = imageUrl;
    }
}
