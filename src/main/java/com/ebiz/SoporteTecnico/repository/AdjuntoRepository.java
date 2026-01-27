package com.ebiz.SoporteTecnico.repository;

import com.ebiz.SoporteTecnico.entity.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdjuntoRepository extends JpaRepository<Adjunto, Long> {
    List<Adjunto> findByTicketId(Long ticketId);
}
