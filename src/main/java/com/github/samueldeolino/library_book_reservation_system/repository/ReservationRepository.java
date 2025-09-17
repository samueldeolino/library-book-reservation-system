package com.github.samueldeolino.library_book_reservation_system.repository;

import com.github.samueldeolino.library_book_reservation_system.model.entity.ReservationsEntities;
import com.github.samueldeolino.library_book_reservation_system.model.enums.StatusReservationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationsEntities, Long> {

    List<ReservationsEntities> findByUserPhoneNumber(String phone);

    int countByUserPhoneNumberAndStatus(String PhoneNumber, StatusReservationEnum status);
}
