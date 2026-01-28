package com.ebiz.SoporteTecnico.repository;

import com.ebiz.SoporteTecnico.entity.Usuario;
import com.ebiz.SoporteTecnico.entity.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
    List<Usuario> findByRol(Rol rol);

    boolean existsByUsuario(String usuario);
    boolean existsByEmail(String email);
}
