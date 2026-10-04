package dev.com.GerenciamentoBiblioteca.DTOs.Livro;

import dev.com.GerenciamentoBiblioteca.model.enums.CategoriaEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LivroRequestDTO {

    @NotNull(message = "O ID isbn do livro é obrigatório")
    String  isbn;

    @NotNull(message = "O titulo do livro é obrigatório")
    String titulo;

    @NotNull(message = "O nome do autor é obrigatório")
    String autor;

    @NotNull(message = "A quantidade de exemplares é obrigatória")
    @Min(value = 0,message = "a quantidade não pode ser menor que zero")
    Integer quantidadeExemplares;

    @NotNull(message = "A categoria do livro é obrigatória")
    CategoriaEnum categoria;
}
