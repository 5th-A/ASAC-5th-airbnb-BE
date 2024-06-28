package org.example.airbnb.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.airbnb.domain.room.entity.Room;
import org.example.airbnb.domain.room.repository.RoomRepository;
import org.example.airbnb.domain.user.dto.MainHostResponseDto;
import org.example.airbnb.domain.user.dto.UserResponseDto;
import org.example.airbnb.domain.user.entity.User;
import org.example.airbnb.domain.user.repository.UserRepository;
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
            Room room = roomRepository.findById(roomId).orElse(null);
            String description = room.getDESCRIPTION();
            User user = userRepository.findById(userId).orElse(null);
            UserResponseDto userResponseDto = UserResponseDto.of(user);
            MainHostResponseDto mainHostResponseDto = MainHostResponseDto.of(userResponseDto, description);

            return mainHostResponseDto;
        }
        catch (RuntimeException exception){
            throw new SQLException(exception);
        }
    }
}
