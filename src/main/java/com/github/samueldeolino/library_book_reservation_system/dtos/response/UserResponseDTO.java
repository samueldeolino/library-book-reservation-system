package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.entity.UsersEntities;

public record UserResponseDTO (
    Long id,
    String name,
    String phoneNumber
)
{
    public static UserResponseDTO fromEntity(UsersEntities user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getPhoneNumber()
        );
    }
}
