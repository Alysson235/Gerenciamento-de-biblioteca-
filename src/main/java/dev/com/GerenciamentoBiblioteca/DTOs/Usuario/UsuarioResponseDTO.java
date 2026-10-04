package dev.com.GerenciamentoBiblioteca.DTOs.Usuario;

import dev.com.GerenciamentoBiblioteca.model.enums.TipoEnum;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        TipoEnum tipo
) {}
