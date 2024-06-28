package org.example.airbnb.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.entity.Comment;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class CommentDto {
    private Long id;
    private String userProfile;
    private Integer rate;
    private String userName;
    private String userCountry;
    private LocalDate date;
    private String message;

    public static CommentDto from(Comment comment, String userName, String userProfile, String userCountry){
        return CommentDto.builder()
                .id(comment.getId())
                .userProfile(userProfile)
                .rate(comment.getRate())
                .userName(userName)
                .userCountry(userCountry)
                .date(comment.getDate().toLocalDate())
                .message(comment.getContent())
                .build();
    }
    @Builder
    public CommentDto(Long id, String userProfile, Integer rate, String userName, String userCountry, LocalDate date, String message) {
        this.id = id;
        this.userProfile = userProfile;
        this.rate = rate;
        this.userName = userName;
        this.userCountry = userCountry;
        this.date = date;
        this.message = message;
    }
}
