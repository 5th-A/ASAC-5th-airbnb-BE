package org.example.airbnb.domain.facility.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.airbnb.domain.facility.entity.Facility;

@AllArgsConstructor
@Getter
public class HouseFacilityResponseDto {
    private final Long id;
    @JsonProperty(value = "url")
    private final String icon;
    @JsonProperty(value = "text")
    private final String name;

    public static HouseFacilityResponseDto of(Facility facility){
       return new HouseFacilityResponseDto(
                facility.getId(),
                facility.getIcon(),
                facility.getName()
        );
    }
}
