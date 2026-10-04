package dev.com.GerenciamentoBiblioteca.repository;

import dev.com.GerenciamentoBiblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
