package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.enums.StatusReservationEnum;

import java.time.LocalDateTime;

public record ReservationResponseDTO(
    Long id,
    StatusReservationEnum status,
    LocalDateTime createdAt,
    BookInReservationResponseDTO book,
    UserInReservationResponseDTO user
) {}
