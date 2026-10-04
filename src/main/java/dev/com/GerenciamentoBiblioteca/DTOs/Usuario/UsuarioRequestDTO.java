package dev.com.GerenciamentoBiblioteca.DTOs.Usuario;

import dev.com.GerenciamentoBiblioteca.model.enums.TipoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotNull(message = "O nome do usuário é obrigatório")
    String nome;

    @NotNull(message = "O email do usuário é obrigatório")
    @Email(message = "Email inválido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "O formato do e-mail não atende aos padrões permitidos.")
    String email;

    @NotNull(message = "O tipo do usuário é obrigatório")
    TipoEnum tipo;
}
