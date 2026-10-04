package dev.com.GerenciamentoBiblioteca.controller;

import dev.com.GerenciamentoBiblioteca.DTOs.Livro.LivroRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Livro.LivroResponseDTO;
import dev.com.GerenciamentoBiblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrarLivro(@RequestBody LivroRequestDTO dto){
        LivroResponseDTO livroCriado = livroService.cadastrarLivro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCriado);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarLivros(){
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("{isbn}")
    public ResponseEntity<LivroResponseDTO> buscarLivroID(@PathVariable String isbn){
        return ResponseEntity.ok(livroService.buscarLivroID(isbn));
    }

    @PutMapping("{isbn}")
    public ResponseEntity<LivroResponseDTO> atualizarLivro(@PathVariable String isbn, @RequestBody LivroRequestDTO dto){
        return ResponseEntity.ok(livroService.atualizarLivro(isbn, dto));
    }

    @DeleteMapping("{isbn}")
    public ResponseEntity<Void> deletarLivro(@PathVariable String isbn){
        livroService.deletarLivro(isbn);
        return ResponseEntity.noContent().build();
    }

}
