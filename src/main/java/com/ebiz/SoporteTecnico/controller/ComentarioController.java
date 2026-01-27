package com.ebiz.SoporteTecnico.controller;

import com.ebiz.SoporteTecnico.service.ComentarioService;
import com.ebiz.SoporteTecnico.service.dto.entrada.ComentarioRequestDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.ComentarioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> agregar(@Valid @RequestBody ComentarioRequestDTO request) {
        return ResponseEntity.ok(comentarioService.agregarComentario(request));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<List<ComentarioResponseDTO>> listarPorTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(comentarioService.listarComentariosPorTicket(ticketId));
    }
}