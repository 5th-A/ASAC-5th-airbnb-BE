package org.example.airbnb.domain.facility.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.facility.entity.Facility;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FacilityResponseDto {
    private Long id;
    @JsonProperty(value = "url")
    private String icon;
    @JsonProperty(value = "text")
    private String name;

    public static FacilityResponseDto of(Facility facility){
        return FacilityResponseDto.builder()
                .id(facility.getId())
                .icon(facility.getIcon())
                .name(facility.getName())
                .build();
    }
}
