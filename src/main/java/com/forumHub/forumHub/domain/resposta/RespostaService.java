package com.forumHub.forumHub.domain.resposta;
import com.forumHub.forumHub.domain.topico.Topico;
import com.forumHub.forumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class RespostaService {


    @Autowired
    public RespostaRepository respostaRepository;

    @Autowired
    public TopicoRepository topicoRepository;



    public Resposta salvarResposta(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public Resposta buscarRespostaPorId(Long id) {
        return respostaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Resposta não encontrada"));
    }

    public List<Resposta> listarRespostasPorTopico(Topico topico) {
        return respostaRepository.findByTopico(topico);
    }

    public void deletarResposta(Long id) {
        respostaRepository.deleteById(id);
    }

}
