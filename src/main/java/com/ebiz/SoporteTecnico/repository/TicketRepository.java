package com.ebiz.SoporteTecnico.repository;

import com.ebiz.SoporteTecnico.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCreadorId(Long creadorId);

    List<Ticket> findByTecnicoAsignadoId(Long tecnicoId);
}
