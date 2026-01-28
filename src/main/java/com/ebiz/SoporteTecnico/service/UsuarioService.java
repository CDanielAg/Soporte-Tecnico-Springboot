package com.ebiz.SoporteTecnico.service;

import com.ebiz.SoporteTecnico.entity.enums.Rol;
import com.ebiz.SoporteTecnico.service.dto.entrada.LoginDTO;
import com.ebiz.SoporteTecnico.service.dto.entrada.UsuarioRegistroDTO;
import com.ebiz.SoporteTecnico.service.dto.salida.UsuarioDTO;
import com.ebiz.SoporteTecnico.entity.Usuario;
import com.ebiz.SoporteTecnico.mapper.UsuarioMapper;
import com.ebiz.SoporteTecnico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO registrarUsuario(UsuarioRegistroDTO registroDTO) {
        if (usuarioRepository.existsByUsuario(registroDTO.getUsuario())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = usuarioMapper.toEntity(registroDTO);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public UsuarioDTO login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByUsuario(loginDTO.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuarioMapper.toDTO(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarTecnicos() {
        return usuarioRepository.findByRol("TECNICO").stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}