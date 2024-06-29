package org.example.airbnb.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.user.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponseDto {
    private String name;
    private String profile;
    private Integer year;
    private String type;

    public static UserResponseDto of(User user){
        return new UserResponseDto(
                user.getName(),
                user.getProfile(),
                Integer.parseInt(user.getRegDate().toString().substring(0,4)),
                user.getSuperhost() == true ? "슈퍼호스트" : "호스트"
        );
    }
}
