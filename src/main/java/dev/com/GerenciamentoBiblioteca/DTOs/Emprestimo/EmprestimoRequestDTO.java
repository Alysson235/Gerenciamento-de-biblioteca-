package dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmprestimoRequestDTO {

        @NotBlank
        private String livroId;
        @NotBlank
        private Long usuarioId;
}
