package com.github.samueldeolino.library_book_reservation_system.dtos.response;

import com.github.samueldeolino.library_book_reservation_system.model.entity.BooksEntities;

public record BookResponseDTO(
    String title,
    String author,
    String isbn,
    int availableQuantity
) {
    public static BookResponseDTO fromEntity(BooksEntities book) {
        return new BookResponseDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getAvailableQuantity());
    }
}
