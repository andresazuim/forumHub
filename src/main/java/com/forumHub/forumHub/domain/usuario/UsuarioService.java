package com.forumHub.forumHub.domain.usuario;

import com.forumHub.forumHub.domain.curso.Curso;
import com.forumHub.forumHub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Usuario cadastrar(DadosUsuario dados) {

        var nomeCurso = dados.curso().getNome().toLowerCase().trim();
        var curso = cursoRepository.findByNome(nomeCurso);

        if (curso == null) {
            try {
                Curso novoCurso = new Curso(nomeCurso);
                Curso savedCurso = cursoRepository.save(novoCurso);
                throw new Exception("Novo curso adicionado no banco de dados: " + savedCurso.getNome());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        Usuario novoUsuario = new Usuario(dados);
        novoUsuario.setCurso(curso);
        return usuarioRepository.save(novoUsuario);

    }
    public Usuario listaUsuarioID(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }
}
