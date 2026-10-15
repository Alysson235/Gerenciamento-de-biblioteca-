package dev.com.GerenciamentoBiblioteca.controller;

import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoResponseDTO;
import dev.com.GerenciamentoBiblioteca.model.Emprestimo;
import dev.com.GerenciamentoBiblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO>  realizarEmprestimo(@RequestBody EmprestimoRequestDTO requestDTO){
        EmprestimoResponseDTO responseDTO = emprestimoService.efetuarEmrprestimo(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<EmprestimoResponseDTO>> listarTodos(){
        List<EmprestimoResponseDTO> emprestimos = emprestimoService.listarTodos();
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/atrasados")
    public ResponseEntity<List<EmprestimoResponseDTO>> listarEmprestimosAtrasados(){
        List<EmprestimoResponseDTO> atrasados = emprestimoService.listarEmprestimosAtrasados();
        return ResponseEntity.ok(atrasados);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Emprestimo>> listarPorUsuario(@PathVariable Long usuarioId){
        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimoPorUsuario(usuarioId);
        return ResponseEntity.ok(emprestimos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> devolverEmprestimo(@PathVariable Long id){
        Emprestimo emprestimoAtualizado = emprestimoService.registrarDevolucao(id);
        return ResponseEntity.ok(emprestimoAtualizado);
    }
}