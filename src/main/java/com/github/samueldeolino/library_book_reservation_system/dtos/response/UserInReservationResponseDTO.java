package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.entity.UsersEntities;

public record UserInReservationResponseDTO(
    Long id,
    String name
) {
    public static UserInReservationResponseDTO fromEntity(UsersEntities user) {
        return new UserInReservationResponseDTO(user.getId(), user.getName());
    }
}
