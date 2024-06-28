package org.example.airbnb.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MainHostResponseDto {
    @JsonProperty(value = "user")
    private UserResponseDto userResponseDto;
    private String introduction;

    public static MainHostResponseDto of(UserResponseDto userResponseDto, String introduction){
        return MainHostResponseDto
                .builder()
                .userResponseDto(userResponseDto)
                .introduction(introduction)
                .build();
    }

    @Builder
    private MainHostResponseDto(UserResponseDto userResponseDto, String introduction) {
        this.userResponseDto = userResponseDto;
        this.introduction = introduction;
    }
}
