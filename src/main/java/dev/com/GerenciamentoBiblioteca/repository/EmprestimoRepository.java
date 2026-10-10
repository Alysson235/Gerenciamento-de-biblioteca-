package dev.com.GerenciamentoBiblioteca.repository;

import dev.com.GerenciamentoBiblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    long countByUsuarioIdAndAtivoTrue(Long usuarioId);
}
