package com.forumHub.forumHub.controller;

import com.forumHub.forumHub.domain.curso.DadosCursos;
import com.forumHub.forumHub.domain.topico.DadosTopicos;
import com.forumHub.forumHub.domain.topico.Topico;
import com.forumHub.forumHub.domain.topico.TopicoService;
import com.forumHub.forumHub.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody DadosUsuario dados, UriComponentsBuilder uriBuilder) {
        Usuario novoUsuario = usuarioService.cadastrar(dados);
        //repository.save(novoUsuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(novoUsuario));
    }


}
