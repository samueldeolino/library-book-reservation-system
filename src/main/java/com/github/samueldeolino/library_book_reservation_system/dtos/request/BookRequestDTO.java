package com.github.samueldeolino.library_book_reservation_system.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequestDTO(
    @NotBlank(message = "book name is required")
    String title,

    @NotBlank(message = "author name is required")
    String author,

    @NotBlank(message = "isbn code is required")
    String isbn,

    @NotNull(message = "available quantity is required")
    @Min(1)
    int totalQuantity
) {
}
