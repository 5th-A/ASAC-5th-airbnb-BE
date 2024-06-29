package org.example.airbnb.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentRequestDto {
    private Long userId;
    private Integer rate;
    private LocalDate date;
    private String msg;
}
