package com.github.samueldeolino.library_book_reservation_system.model.entity;

import com.github.samueldeolino.library_book_reservation_system.model.enums.StatusReservationEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "reservations")
public class ReservationsEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntities user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BooksEntities bookReserved;

    @Enumerated(EnumType.STRING)
    private StatusReservationEnum status;

    @Column(nullable = false)
    private LocalDateTime created_at;
}
