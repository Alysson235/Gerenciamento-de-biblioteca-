package dev.com.GerenciamentoBiblioteca.controller;

import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoResponseDTO;
import dev.com.GerenciamentoBiblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}