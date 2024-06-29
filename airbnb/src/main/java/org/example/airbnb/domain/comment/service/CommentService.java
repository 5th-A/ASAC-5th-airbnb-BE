package org.example.airbnb.domain.comment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.comment.dto.CommentDto;
import org.example.airbnb.domain.comment.dto.CommentRequestDto;
import org.example.airbnb.domain.comment.dto.CommentResponseDto;
import org.example.airbnb.domain.comment.entity.Comment;
import org.example.airbnb.domain.comment.repository.CommentRepository;
import org.example.airbnb.domain.image.dto.ImageDto;
import org.example.airbnb.domain.room.dto.RoomDto;
import org.example.airbnb.domain.room.dto.RoomResponseDto;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.exception.CommentException;
import org.example.airbnb.exception.CustomRuntimeException;
import org.example.airbnb.exception.RoomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final RoomRepository roomRepository;

    public CommentResponseDto findCommentByRoomId(Long roomId) {
        List<Comment> comments = commentRepository.findCommentByRoomId(roomId);
        List<CommentDto> commentDtos = comments.stream().
                map(CommentDto::from).
                collect(Collectors.toList());
        Double avg = commentRepository.findTotalAvg(roomId);
        CommentResponseDto responseDto = CommentResponseDto.of(avg, commentDtos);
        return responseDto;
    }

    @Transactional
    public CommentDto saveComment(Long roomId, CommentRequestDto commentRequestDto) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> {
            throw new CustomRuntimeException(RoomException.ROOM_NOT_FOUND_EXCEPTION);
        });
        Comment comment = Comment.of(commentRequestDto, room);
        Comment savedComment = commentRepository.save(comment);
        CommentDto responseCommentDto = CommentDto.from(savedComment);
        return responseCommentDto;
    }
}
