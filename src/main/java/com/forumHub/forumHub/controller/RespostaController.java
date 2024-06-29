package com.forumHub.forumHub.controller;

import com.forumHub.forumHub.domain.resposta.DadosDetalhamentoRespostas;
import com.forumHub.forumHub.domain.resposta.DadosRespostas;
import com.forumHub.forumHub.domain.resposta.Resposta;
import com.forumHub.forumHub.domain.resposta.RespostaService;
import com.forumHub.forumHub.domain.topico.Topico;
import com.forumHub.forumHub.domain.topico.TopicoService;
import com.forumHub.forumHub.domain.usuario.Usuario;
import com.forumHub.forumHub.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;
    @Autowired
    private TopicoService topicoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/topicos/{topicoId}/respostas")
    public List<DadosRespostas> listarRespostas(@PathVariable Long topicoId) {
        Topico topico = topicoService.listaTopicoID(topicoId)
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        List<Resposta> respostas = respostaService.listarRespostasPorTopico(topico);
        return respostas.stream()
                .map(resposta -> new DadosRespostas(
                        resposta.getId(),
                        resposta.getConteudo(),
                        resposta.getAutor().getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/topicos/{topicoId}/respostas")
    public DadosRespostas adicionarResposta(@PathVariable Long topicoId, @RequestBody DadosDetalhamentoRespostas dadosCriacaoResposta) {
        Topico topico = topicoService.listaTopicoID(topicoId)
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        Usuario autor = usuarioService.listaUsuarioID(dadosCriacaoResposta.autorId());

        Resposta novaResposta = new Resposta();
        novaResposta.setConteudo(dadosCriacaoResposta.conteudo());
        novaResposta.setAutor(autor);
        novaResposta.setTopico(topico);
        novaResposta.setSolucao(false);

        respostaService.salvarResposta(novaResposta);

        return new DadosRespostas(
                novaResposta.getId(),
                novaResposta.getConteudo(),
                novaResposta.getAutor().getId()
        );
    }
    @DeleteMapping("/topicos/{topicoId}/respostas/{respostaId}")
    public ResponseEntity<Void> apagarResposta(@PathVariable Long topicoId, @PathVariable Long respostaId) {
        Topico topico = topicoService.listaTopicoID(topicoId)
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        Resposta resposta = respostaService.buscarRespostaPorId(respostaId);
        if (!resposta.getTopico().equals(topico)) {
            throw new IllegalArgumentException("A resposta não pertence ao tópico especificado.");
        }

        respostaService.deletarResposta(respostaId);

        return ResponseEntity.noContent().build();
    }
}
