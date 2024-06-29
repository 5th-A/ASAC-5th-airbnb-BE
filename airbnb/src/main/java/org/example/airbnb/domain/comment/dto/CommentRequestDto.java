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
    private LocalDate date; // JpaAudting을 통해 자동으로 날짜를 넣어주지만 JSON Request로 받기 때문에 삭제하지 않고 넣어둠.
    private String msg;
}
