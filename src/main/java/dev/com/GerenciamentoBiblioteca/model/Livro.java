package dev.com.GerenciamentoBiblioteca.model;

import dev.com.GerenciamentoBiblioteca.model.enums.CategoriaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @Column(length = 13)
    @Pattern(regexp = "^\\d{13}$", message = "ISBN deve ter 13 dígitos")
    private String isbn;

    private String titulo;
    private String autor;
    private Integer quantidadeExemplares;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

}
