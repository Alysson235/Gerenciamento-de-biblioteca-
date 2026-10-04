package dev.com.GerenciamentoBiblioteca.service;

import dev.com.GerenciamentoBiblioteca.DTOs.Usuario.UsuarioRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Usuario.UsuarioResponseDTO;
import dev.com.GerenciamentoBiblioteca.model.Usuario;
import dev.com.GerenciamentoBiblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario toEntity(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTipo(dto.getTipo());
        return usuario;
    }
    private UsuarioResponseDTO toResponseDTO(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto){
        Usuario usuario = toEntity(dto);

        return toResponseDTO(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponseDTO> listarUsuarios(){
        return usuarioRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public UsuarioResponseDTO buscarUsuarioID(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException(""));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTipo(dto.getTipo());

        return toResponseDTO(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else{
            throw new RuntimeException("O ID que você quer deletar não existe");
        }
    }
}
