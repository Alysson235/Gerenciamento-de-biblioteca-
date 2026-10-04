package dev.com.GerenciamentoBiblioteca.model;

import dev.com.GerenciamentoBiblioteca.model.enums.TipoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;

}
