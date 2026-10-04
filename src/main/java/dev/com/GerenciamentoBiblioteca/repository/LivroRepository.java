package dev.com.GerenciamentoBiblioteca.repository;

import dev.com.GerenciamentoBiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, String> {
}
