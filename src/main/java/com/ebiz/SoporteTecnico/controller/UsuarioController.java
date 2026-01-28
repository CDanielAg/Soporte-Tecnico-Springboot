package com.ebiz.SoporteTecnico.controller;

import com.ebiz.SoporteTecnico.service.UsuarioService;
import com.ebiz.SoporteTecnico.service.dto.entrada.LoginDTO;
import com.ebiz.SoporteTecnico.service.dto.entrada.UsuarioRegistroDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrar(@Valid @RequestBody UsuarioRegistroDTO registroDTO) {
        UsuarioDTO nuevoUsuario = usuarioService.registrarUsuario(registroDTO);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        UsuarioDTO usuario = usuarioService.login(loginDTO);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/tecnicos")
    public ResponseEntity<List<UsuarioDTO>> tecnicos() {
        return  ResponseEntity.ok(usuarioService.listarTecnicos());
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
}