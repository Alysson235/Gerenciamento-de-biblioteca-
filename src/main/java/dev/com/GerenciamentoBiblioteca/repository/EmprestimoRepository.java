package dev.com.GerenciamentoBiblioteca.repository;

import dev.com.GerenciamentoBiblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    long countByUsuarioIdAndAtivoTrue(Long usuarioId);

    List<Emprestimo> findByUsuarioId(Long usuarioId);

    List<Emprestimo> findByAtivoTrueAndDataPrevistaDevolucaoBefore(LocalDate dataAtual);
}
