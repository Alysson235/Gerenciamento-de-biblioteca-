package dev.com.GerenciamentoBiblioteca.DTOs.Livro;

import dev.com.GerenciamentoBiblioteca.model.enums.CategoriaEnum;

public record LivroResponseDTO(
        String isbn,
        String autor,
        Integer quantidade,
        CategoriaEnum categoria
) {}
