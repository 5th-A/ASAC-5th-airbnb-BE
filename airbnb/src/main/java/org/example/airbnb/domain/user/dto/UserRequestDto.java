package org.example.airbnb.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    private String name;
    private String profile;
    private LocalDate regDate;
    private Boolean superhost;

    @Builder
    private UserRequestDto(String name, String profile, LocalDate regDate, Boolean superhost) {
        this.name = name;
        this.profile = profile;
        this.regDate = regDate;
        this.superhost = superhost;
    }
}
