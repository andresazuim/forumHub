package com.forumHub.forumHub.domain.topico;

import com.forumHub.forumHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record DadosTopicos(
        Long id,

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,

        @NotBlank
        String autorId) {


    public String titulo() {
        return titulo.trim();
    }
    public String mensagem() {
        return mensagem.trim();
    }

    }
