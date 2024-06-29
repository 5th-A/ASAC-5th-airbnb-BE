package org.example.airbnb.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.entity.Comment;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
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

    public static CommentDto from(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getRate(),
                comment.getDate().toLocalDate(),
                comment.getContent(),
                comment.getUser().getProfile(),
                comment.getUser().getName(),
                comment.getUser().getCountry().getName()
        );
    }
}
