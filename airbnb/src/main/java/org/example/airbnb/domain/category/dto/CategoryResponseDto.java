package org.example.airbnb.domain.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.category.entity.Category;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CategoryResponseDto {
    private Long id;
    private String icon;
    private String name;

    public static CategoryResponseDto of(Category category){
        return CategoryResponseDto.builder()
                .id(category.getId())
                .icon(category.getIcon())
                .name(category.getName())
                .build();
    }
}



