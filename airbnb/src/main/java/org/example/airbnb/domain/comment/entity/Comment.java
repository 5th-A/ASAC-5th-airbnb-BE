package org.example.airbnb.domain.comment.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "RATE")
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    private Comment(Long id, String content, LocalDateTime date, Integer rate, Room room, User user) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.rate = rate;
        this.room = room;
        this.user = user;
    }
}
