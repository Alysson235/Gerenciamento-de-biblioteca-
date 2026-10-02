package dev.com.GerenciamentoBiblioteca.model;

import dev.com.GerenciamentoBiblioteca.model.enums.CategoriaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @ISBN(type = ISBN.Type.ISBN_13)
    private String isbn;

    private String autor;
    private Integer quantidadeExemplares;
    private CategoriaEnum categoria;

}
