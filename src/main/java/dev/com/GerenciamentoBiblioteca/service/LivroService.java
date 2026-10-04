package dev.com.GerenciamentoBiblioteca.service;

import dev.com.GerenciamentoBiblioteca.DTOs.Livro.LivroRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Livro.LivroResponseDTO;
import dev.com.GerenciamentoBiblioteca.model.Livro;
import dev.com.GerenciamentoBiblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    private Livro toEntity(LivroRequestDTO dto){
        Livro livro = new Livro();
        livro.setIsbn(dto.getIsbn());
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setQuantidadeExemplares(dto.getQuantidadeExemplares());
        livro.setCategoria(dto.getCategoria());
        return livro;
    }

    private LivroResponseDTO toResponseDTO(Livro livro){
        return new LivroResponseDTO(livro.getIsbn(), livro.getTitulo(), livro.getAutor(), livro.getQuantidadeExemplares(),livro.getCategoria());
    }

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO dto){
        Livro livro = toEntity(dto);

        return toResponseDTO(livroRepository.save(livro));
    }

    public List<LivroResponseDTO> listarLivros(){
        return livroRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public LivroResponseDTO buscarLivroID(String isbn){
        Livro livro = livroRepository.findById(isbn).orElseThrow(()-> new RuntimeException("O campo do ID não pode ser vazio"));
        return toResponseDTO(livro);
    }

    public LivroResponseDTO atualizarLivro(String isbn,LivroRequestDTO dto){
        Livro livro = livroRepository.findById(isbn).orElseThrow(()-> new RuntimeException(""));

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setQuantidadeExemplares(dto.getQuantidadeExemplares());
        livro.setCategoria(dto.getCategoria());

        return toResponseDTO(livroRepository.save(livro));
    }

    public void deletarLivro(String isbn){

        if(!livroRepository.existsById(isbn)){
            throw new RuntimeException("Nenhum livro com esse ID encontrado");
        }else {
            livroRepository.deleteById(isbn);
        }
    }
}
