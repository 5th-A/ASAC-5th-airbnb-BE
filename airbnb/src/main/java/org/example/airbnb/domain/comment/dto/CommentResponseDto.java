package org.example.airbnb.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.entity.Comment;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class CommentResponseDto {
    @JsonProperty(value = "average")
    private Double averageRate;
    @JsonProperty(value = "comment")
    private List<CommentDto> comments;

    public static CommentResponseDto of(Double averageRate, List<CommentDto> comments){
        return CommentResponseDto.builder()
                .averageRate(averageRate)
                .comments(comments)
                .build();
    }
    @Builder
    private CommentResponseDto(Double averageRate, List<CommentDto> comments) {
        this.averageRate = averageRate;
        this.comments = comments;
    }
}
