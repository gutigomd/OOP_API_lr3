package com.example.coworking.repository;
import com.example.coworking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByStatus(String status);
    List<Reservation> findByWorkspaceId(Long workspaceId);
}