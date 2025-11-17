package com.github.samueldeolino.library_book_reservation_system.repository;

import com.github.samueldeolino.library_book_reservation_system.model.entity.BooksEntities;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BooksEntities, Long> {

    Optional<BooksEntities> findByIsbn(@NotBlank(message = "isbn code is required") String isbn);
}
