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
@Getter
public class FacilityResponseDto {
    private Long id;
    @JsonProperty(value = "icon")
    private String icon;
    @JsonProperty(value = "name")
    private String name;

    public static FacilityResponseDto of(Facility facility){
        FacilityResponseDto dto = new FacilityResponseDto();
        dto.id = facility.getId();
        dto.icon = facility.getIcon();
        dto.name = facility.getName();
        return dto;
    }
}
