package com.github.samueldeolino.library_book_reservation_system.repository;

import com.github.samueldeolino.library_book_reservation_system.model.entity.BooksEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BooksEntities, Long> {
}
