package dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmprestimoResponseDTO{

    private Long id;
    private String nomeLivro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private boolean ativo = true;
}
