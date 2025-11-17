package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.entity.ReservationsEntities;
import com.github.samueldeolino.library_book_reservation_system.model.enums.StatusReservationEnum;

import java.time.LocalDateTime;

public record ReservationResponseDTO(
    Long id,
    StatusReservationEnum status,
    LocalDateTime createdAt,
    BookInReservationResponseDTO book,
    UserInReservationResponseDTO user
) {
    public static ReservationResponseDTO fromEntity(ReservationsEntities reservation) {

        BookInReservationResponseDTO bookDTO = BookInReservationResponseDTO.fromEntity(reservation.getBookReserved());
        UserInReservationResponseDTO userDTO = UserInReservationResponseDTO.fromEntity(reservation.getUser());

        return new ReservationResponseDTO(
                reservation.getId(),
                reservation.getStatus(),
                reservation.getCreatedAt(),
                bookDTO,
                userDTO
        );
    }
}
