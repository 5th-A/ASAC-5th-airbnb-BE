package org.example.airbnb.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.entity.Comment;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class CommentResponseDto {
    @JsonProperty(value = "average")
    private final Double averageRate;
    @JsonProperty(value = "comment")
    private final List<CommentDto> comments;

    public static CommentResponseDto of(Double averageRate, List<CommentDto> comments){
        return new CommentResponseDto(
                averageRate,
                comments
        );
    }
}
