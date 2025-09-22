package com.github.samueldeolino.library_book_reservation_system.dtos.request;

import jakarta.validation.constraints.NotNull;

public record ReservationRequestDTO(
    @NotNull(message = "user id is required")
    Long userId,

    @NotNull(message = "book id is required")
    Long bookId
) {}
