package org.example.airbnb.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public static CommentDto from(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.id = comment.getId();
        dto.rate = comment.getRate();
        dto.date = comment.getDate().toLocalDate();
        dto.message = comment.getContent();
        dto.profile = comment.getUser().getProfile();
        dto.name = comment.getUser().getName();
        dto.country = comment.getUser().getCountry().getName();
        return dto;
    }
}
