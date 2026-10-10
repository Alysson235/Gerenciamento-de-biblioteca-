package dev.com.GerenciamentoBiblioteca.service;

import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoRequestDTO;
import dev.com.GerenciamentoBiblioteca.DTOs.Emprestimo.EmprestimoResponseDTO;
import dev.com.GerenciamentoBiblioteca.model.Emprestimo;
import dev.com.GerenciamentoBiblioteca.model.Livro;
import dev.com.GerenciamentoBiblioteca.model.Usuario;
import dev.com.GerenciamentoBiblioteca.repository.EmprestimoRepository;
import dev.com.GerenciamentoBiblioteca.repository.LivroRepository;
import dev.com.GerenciamentoBiblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;

    @Transactional
    public EmprestimoResponseDTO efetuarEmrprestimo(EmprestimoRequestDTO requestDTO){

        Livro livro = livroRepository.findById(requestDTO.getLivroId()).orElseThrow(()-> new RuntimeException("Livro não encontrado. "));

        if (livro.getQuantidadeExemplares()<=0){
            throw new RuntimeException("Não há exemplares disponíveis deste livro para empréstimo.");
        }

        Usuario usuario =  usuarioRepository.findById(requestDTO.getUsuarioId()).orElseThrow(()->new RuntimeException("Usuário não encontrado. "));

        long emprestimosAtivos = emprestimoRepository.countByUsuarioIdAndAtivoTrue(requestDTO.getUsuarioId());
        int limiteMaximo = switch (usuario.getTipo()){
            case ALUNO -> 3;
            case PROFESSOR -> 10;
        };

        if (emprestimosAtivos >= limiteMaximo){
            String tipoFormato = usuario.getTipo().name().toLowerCase();
            throw new RuntimeException("O"+ tipoFormato + "atingiu o limite máximo de " +limiteMaximo+ "empréstimos ativos. ");
        }

        livro.setQuantidadeExemplares(livro.getQuantidadeExemplares()-1);
        livroRepository.save(livro);

        LocalDate hoje = LocalDate.now();
        int diasDePrazo = 14;

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setAtivo(true);
        emprestimo.setDataRetirada(hoje);
        emprestimo.setDataPrevistaDevolucao(hoje.plusDays(diasDePrazo));

        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

        EmprestimoResponseDTO responseDTO = new EmprestimoResponseDTO();
        responseDTO.setId(emprestimoSalvo.getId());
        responseDTO.setNomeLivro(livro.getTitulo());
        responseDTO.setNomeUsuario(usuario.getNome());
        responseDTO.setDataEmprestimo(emprestimoSalvo.getDataRetirada());
        responseDTO.setDataPrevistaDevolucao(emprestimoSalvo.getDataPrevistaDevolucao());

        return responseDTO;

    }
}