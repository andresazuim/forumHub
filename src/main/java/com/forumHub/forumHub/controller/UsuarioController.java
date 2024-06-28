package com.forumHub.forumHub.controller;

import com.forumHub.forumHub.domain.curso.DadosCursos;
import com.forumHub.forumHub.domain.topico.DadosTopicos;
import com.forumHub.forumHub.domain.topico.Topico;
import com.forumHub.forumHub.domain.topico.TopicoService;
import com.forumHub.forumHub.domain.usuario.DadosUsuario;
import com.forumHub.forumHub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastro(@Valid @RequestBody DadosUsuario dados) {
        usuarioService.cadastrar(dados);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

}
