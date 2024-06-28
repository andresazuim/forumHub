package com.forumHub.forumHub.domain.resposta;

import com.forumHub.forumHub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RespostaRepository  extends JpaRepository<Resposta, Long> {
    List<Resposta> findByTopico(Topico topico);


}
