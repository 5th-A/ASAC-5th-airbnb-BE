package org.example.airbnb.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.entity.Comment;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class CommentDto {
    private Long id;
    private Integer rate;
    private LocalDate date;
    @JsonProperty(value = "msg")
    private String message;
    private String profile;
    private String name;
    @JsonProperty(value = "location")
    private String country;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .rate(comment.getRate())
                .date(comment.getDate().toLocalDate())
                .message(comment.getContent())
                .profile(comment.getUser().getProfile())
                .name(comment.getUser().getName())
                .country(comment.getUser().getCountry().getName())
                .build();
    }
    @Builder
    public CommentDto(Long id, Integer rate, LocalDate date, String message,String profile, String name, String country) {
        this.id = id;
        this.rate = rate;
        this.date = date;
        this.message = message;
        this.profile = profile;
        this.name = name;
        this.country = country;
    }
}
