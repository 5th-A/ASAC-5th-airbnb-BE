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
        ImageDto dto = new ImageDto();
        dto.id = image.getId();
        dto.url = image.getImageUrl();
        return dto;
    }
}
