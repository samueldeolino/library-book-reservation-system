package com.github.samueldeolino.library_book_reservation_system.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO (
    @NotNull(message = "user id is required")
    Long id,

    @NotBlank(message = "user name is required")
    String name,

    @NotBlank(message = "user phone number is required")
    String phoneNumber
){}
