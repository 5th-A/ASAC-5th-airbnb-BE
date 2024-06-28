package org.example.airbnb.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.comment.dto.CommentDto;
import org.example.airbnb.domain.comment.dto.CommentResponseDto;
import org.example.airbnb.domain.comment.entity.Comment;
import org.example.airbnb.domain.comment.repository.CommentRepository;
import org.example.airbnb.domain.image.dto.ImageDto;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.exception.CommentException;
import org.example.airbnb.exception.CustomRuntimeException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto findByRoomId(Long roomId) {
        List<Comment> comments = commentRepository.findCommentByRoomId(roomId);
        if(comments.isEmpty()) {
            throw new CustomRuntimeException(CommentException.COMMENT_NOT_FOUND_EXCEPTION);
        }
        List<CommentDto> commentDtos = comments.stream().
                map(CommentDto::from).
                collect(Collectors.toList());
        Double avg = commentRepository.findTotalAvg(roomId);
        CommentResponseDto responseDto = CommentResponseDto.of(avg, commentDtos);
        return responseDto;
    }
}
