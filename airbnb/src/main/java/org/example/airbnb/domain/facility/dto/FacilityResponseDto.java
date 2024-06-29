package org.example.airbnb.domain.facility.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.airbnb.domain.facility.entity.Facility;

@AllArgsConstructor
@Getter
public class FacilityResponseDto {
    private final Long id;
    @JsonProperty(value = "icon")
    private final String icon;
    @JsonProperty(value = "name")
    private final String name;

    public static FacilityResponseDto of(Facility facility){
       return new FacilityResponseDto(
                facility.getId(),
                facility.getIcon(),
                facility.getName()
        );
    }
}
