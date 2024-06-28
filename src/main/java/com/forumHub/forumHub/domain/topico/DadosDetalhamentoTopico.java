package com.forumHub.forumHub.domain.topico;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, Boolean status) {
    public  DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getStatus());
    }
}
