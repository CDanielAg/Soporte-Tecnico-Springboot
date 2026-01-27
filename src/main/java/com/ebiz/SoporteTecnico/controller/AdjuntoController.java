package com.ebiz.SoporteTecnico.controller;

import com.ebiz.SoporteTecnico.service.AdjuntoService;
import com.ebiz.SoporteTecnico.service.dto.entrada.AdjuntoRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.AdjuntoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adjuntos")
@CrossOrigin(origins = "http://localhost:4200")
public class AdjuntoController {

    private final AdjuntoService adjuntoService;

    public AdjuntoController(AdjuntoService adjuntoService) {
        this.adjuntoService = adjuntoService;
    }

    @PostMapping
    public ResponseEntity<AdjuntoResponseDTO> subir(@Valid @RequestBody AdjuntoRequestDTO request) {
        return ResponseEntity.ok(adjuntoService.guardarAdjunto(request));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<List<AdjuntoResponseDTO>> listarPorTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(adjuntoService.listarAdjuntosPorTicket(ticketId));
    }
}