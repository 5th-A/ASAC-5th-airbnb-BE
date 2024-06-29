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
        CommentResponseDto dto = new CommentResponseDto();
        dto.averageRate = averageRate;
        dto.comments = comments;
        return dto;
    }
}
