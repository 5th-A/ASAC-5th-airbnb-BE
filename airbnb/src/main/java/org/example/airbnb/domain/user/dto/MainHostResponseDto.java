package org.example.airbnb.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainHostResponseDto {
    @JsonProperty(value = "user")
    private final UserResponseDto userResponseDto;
    private final String introduction;

    public static MainHostResponseDto of(UserResponseDto userResponseDto, String introduction){
        return new MainHostResponseDto(
                userResponseDto,
                introduction
        );
    }
}
