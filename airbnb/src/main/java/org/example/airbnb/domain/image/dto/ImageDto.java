package org.example.airbnb.domain.image.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.airbnb.domain.image.entity.Image;

import java.util.List;

@Getter
@AllArgsConstructor
public class ImageDto {
    private final Long id;
    private final String url;

    public static ImageDto of(Image image){
        return new ImageDto(
                image.getId(),
                image.getImageUrl()
        );
    }
}
