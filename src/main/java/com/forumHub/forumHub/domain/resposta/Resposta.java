package com.forumHub.forumHub.domain.resposta;

import com.forumHub.forumHub.domain.topico.Topico;
import com.forumHub.forumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Table(name = "respostas")
@Entity(name = "Restosta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mensagem;

    private LocalDateTime data_criacao;
    //private boolean solucao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public String getConteudo() {
        return "Mensagem: " + this.mensagem;
    }

    public void setConteudo(String conteudo) {
        this.mensagem = conteudo;

    }
}
