package org.example.airbnb.domain.comment.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.comment.dto.CommentDto;
import org.example.airbnb.domain.comment.dto.CommentRequestDto;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "RATE")
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public static Comment of(CommentRequestDto commentRequestDto, Room room, User user){
        return Comment.builder()
                .content(commentRequestDto.getMsg())
                .user(user)
                .rate(commentRequestDto.getRate())
                .room(room)
                .build();
    }

    @Builder
    private Comment(Long id, String content, Integer rate, Room room, User user) {
        this.id = id;
        this.content = content;
        this.rate = rate;
        this.room = room;
        this.user = user;
    }
}
