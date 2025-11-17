package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.entity.BooksEntities;

public record BookInReservationResponseDTO(
    Long id,
    String title
) {
    public static BookInReservationResponseDTO fromEntity(BooksEntities book) {
        return new BookInReservationResponseDTO(book.getId(), book.getTitle());
    }
}
