package com.forumHub.forumHub.domain.usuario;

import com.forumHub.forumHub.domain.curso.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosUsuario (

                          Long id,
                          @NotBlank
                          String nome,
                          @Email
                          String email,
                          @NotBlank
                          String senha,
                          @NotNull
                          Curso curso
){
}
