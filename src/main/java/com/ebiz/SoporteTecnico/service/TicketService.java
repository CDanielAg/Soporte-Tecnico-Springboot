package com.ebiz.SoporteTecnico.service;

import com.ebiz.SoporteTecnico.service.dto.entrada.TicketRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.entrada.TicketStatusUpdateDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.TicketResponseDTO;
import com.ebiz.SoporteTecnico.entity.Ticket;
import com.ebiz.SoporteTecnico.entity.Usuario;
import com.ebiz.SoporteTecnico.entity.enums.Estado;
import com.ebiz.SoporteTecnico.entity.enums.Rol;
import com.ebiz.SoporteTecnico.mapper.TicketMapper;
import com.ebiz.SoporteTecnico.repository.TicketRepository;
import com.ebiz.SoporteTecnico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, UsuarioRepository usuarioRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketResponseDTO crearTicket(TicketRequestDTO request) {
        Usuario creador = usuarioRepository.findById(request.getCreadorId())
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado"));

        Ticket ticket = ticketMapper.toEntity(request, creador);
        Ticket ticketGuardado = ticketRepository.save(ticket);

        return ticketMapper.toDTO(ticketGuardado);
    }

    public List<TicketResponseDTO> listarTickets(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Ticket> tickets;

        if (usuario.getRol() == Rol.ADMIN) {
            tickets = ticketRepository.findAll();
        } else if (usuario.getRol() == Rol.TECNICO) {
            tickets = ticketRepository.findByTecnicoAsignadoId(usuarioId);
        } else {
            tickets = ticketRepository.findByCreadorId(usuarioId);
        }

        return tickets.stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TicketResponseDTO cambiarEstado(Long ticketId, TicketStatusUpdateDTO updateDTO) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        ticket.setEstado(updateDTO.getNuevoEstado());
        Ticket ticketActualizado = ticketRepository.save(ticket);

        return ticketMapper.toDTO(ticketActualizado);
    }

    public TicketResponseDTO asignarTecnico(Long ticketId, Long tecnicoId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        Usuario tecnico = usuarioRepository.findById(tecnicoId)
                .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));

        if (tecnico.getRol() != Rol.TECNICO) {
            throw new RuntimeException("El usuario asignado no tiene rol de TÉCNICO");
        }

        ticket.setTecnicoAsignado(tecnico);
        ticket.setEstado(Estado.EN_PROGRESO);

        return ticketMapper.toDTO(ticketRepository.save(ticket));
    }

    public TicketResponseDTO obtenerPorId(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        return ticketMapper.toDTO(ticket);
    }
}