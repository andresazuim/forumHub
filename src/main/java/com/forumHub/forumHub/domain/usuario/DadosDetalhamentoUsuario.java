package com.forumHub.forumHub.domain.usuario;

import com.forumHub.forumHub.domain.curso.Curso;

public record DadosDetalhamentoUsuario(long id, String nome, String email, String senha, Curso curso) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCurso());
    }
}
