package com.forumHub.forumHub.domain.topico;

import com.forumHub.forumHub.domain.curso.DadosCursos;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico (
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String nomeAutor,
        DadosCursos curso,
        Boolean status){
}
