package com.forumHub.forumHub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(String titulo);

    boolean existsByMensagem(String mensagem);
}
