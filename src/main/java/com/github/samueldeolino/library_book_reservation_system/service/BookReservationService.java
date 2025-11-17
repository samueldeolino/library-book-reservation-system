package com.github.samueldeolino.library_book_reservation_system.service;

import com.github.samueldeolino.library_book_reservation_system.dtos.request.ReservationRequestDTO;
import com.github.samueldeolino.library_book_reservation_system.dtos.response.ReservationResponseDTO;
import com.github.samueldeolino.library_book_reservation_system.model.entity.BooksEntities;
import com.github.samueldeolino.library_book_reservation_system.model.entity.ReservationsEntities;
import com.github.samueldeolino.library_book_reservation_system.model.entity.UsersEntities;
import com.github.samueldeolino.library_book_reservation_system.model.enums.StatusReservationEnum;
import com.github.samueldeolino.library_book_reservation_system.repository.BookRepository;
import com.github.samueldeolino.library_book_reservation_system.repository.ReservationRepository;
import com.github.samueldeolino.library_book_reservation_system.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookReservationService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public BookReservationService(BookRepository bookRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public ReservationResponseDTO reserveBook(ReservationRequestDTO dto){
        BooksEntities book = bookRepository.findById(dto.bookId()).orElseThrow(()-> new EntityNotFoundException("Book not exist."));

        UsersEntities user = userRepository.findById(dto.userId()).orElseThrow(()-> new EntityNotFoundException("User not exist."));

        var availableQuantity = book.getAvailableQuantity();

        if (availableQuantity <= 0) {
            throw new EntityExistsException("Book with ISBN " + book.getIsbn() + "not available.");
        }

        long numbersAvailableReservation = reservationRepository.countByUserIdAndStatus(user.getId(), StatusReservationEnum.ACTIVE);

        if (numbersAvailableReservation >= 3) {
            throw new EntityExistsException("User has reached the maximum reservation limit.");
        }

        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
        bookRepository.save(book);

        ReservationsEntities newReservation = ReservationsEntities.builder()
                .user(user)
                .bookReserved(book)
                .status(StatusReservationEnum.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();

        ReservationsEntities savedReservation = reservationRepository.save(newReservation);

        return ReservationResponseDTO.fromEntity(savedReservation);
    }

}
