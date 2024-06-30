package org.example.airbnb.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.domain.user.dto.MainHostResponseDto;
import org.example.airbnb.domain.user.dto.UserResponseDto;
import org.example.airbnb.domain.user.entity.User;
import org.example.airbnb.domain.user.repository.UserRepository;
import org.example.airbnb.exception.CustomRuntimeException;
import org.example.airbnb.exception.RoomException;
import org.example.airbnb.exception.UserException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public MainHostResponseDto findRoomById(Long roomId, Long userId) throws SQLException {
        try{
            Room room = roomRepository.findById(roomId).orElseThrow(() -> {
                throw new CustomRuntimeException(RoomException.ROOM_NOT_FOUND_EXCEPTION);
            });
            String description = room.getDESCRIPTION();
            User user = userRepository.findById(userId).orElseThrow(()->{
                throw new CustomRuntimeException(UserException.USER_NOT_FOUND_EXCEPTION);
            });
            UserResponseDto userResponseDto = UserResponseDto.of(user);
            MainHostResponseDto mainHostResponseDto = MainHostResponseDto.of(userResponseDto, description);

            return mainHostResponseDto;
        }
        catch (RuntimeException exception){
            throw new SQLException(exception);
        }
    }
}
