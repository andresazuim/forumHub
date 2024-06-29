package com.forumHub.forumHub.domain.usuario;

import com.forumHub.forumHub.domain.curso.Curso;
import com.forumHub.forumHub.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario cadastrar(DadosUsuario dados) {

        var nomeCurso = dados.curso().getNome().toLowerCase().trim();
        var curso = cursoRepository.findByNome(nomeCurso);

        if (curso == null) {
            Curso novoCurso = new Curso(nomeCurso);
            curso = cursoRepository.save(novoCurso);
        }

        String senhaEncriptada = passwordEncoder.encode(dados.senha());

        dados = new DadosUsuario(dados.id(), dados.nome(), dados.email(), senhaEncriptada, dados.curso());
        Usuario novoUsuario = new Usuario(dados);
        novoUsuario.setCurso(curso);
        return usuarioRepository.save(novoUsuario);
    }

    public Usuario listaUsuarioID(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }
}
