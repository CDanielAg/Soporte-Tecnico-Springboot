package com.ebiz.SoporteTecnico.controller;

import com.ebiz.SoporteTecnico.service.TicketService;
import com.ebiz.SoporteTecnico.service.dto.entrada.TicketRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.entrada.TicketStatusUpdateDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.TicketResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> crear(@Valid @RequestBody TicketRequestDTO request) {
        return ResponseEntity.ok(ticketService.crearTicket(request));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> listar(@RequestParam Long usuarioId) {
        return ResponseEntity.ok(ticketService.listarTickets(usuarioId));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<TicketResponseDTO> cambiarEstado(@PathVariable Long id,
                                                           @Valid @RequestBody TicketStatusUpdateDTO updateDTO) {
        return ResponseEntity.ok(ticketService.cambiarEstado(id, updateDTO));
    }

    @PutMapping("/{id}/asignar")
    public ResponseEntity<TicketResponseDTO> asignarTecnico(@PathVariable Long id,
                                                            @RequestParam Long tecnicoId) {
        return ResponseEntity.ok(ticketService.asignarTecnico(id, tecnicoId));
    }
}