package com.forumHub.forumHub.controller;

import com.forumHub.forumHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicosController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository TopicoRepository;

    @PostMapping
    public ResponseEntity<Topico> criar(@Valid @RequestBody DadosTopicos dados) {
        Topico topico = topicoService.criarTopico(dados);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topico = topicoService.listaTopico();
        return ResponseEntity.ok(topico);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        var topico = TopicoRepository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }


    //editar


}
