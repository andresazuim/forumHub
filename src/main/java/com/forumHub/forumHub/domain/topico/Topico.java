package com.forumHub.forumHub.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.forumHub.forumHub.domain.curso.Curso;
import com.forumHub.forumHub.domain.resposta.Resposta;
import com.forumHub.forumHub.domain.usuario.Usuario;
import com.forumHub.forumHub.domain.usuario.UsuarioNomeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "autor" })
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;
    @Transient
    private String nomeAutor;

    private LocalDateTime data_criacao = LocalDateTime.now();
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonManagedReference
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosTopicos dados) {
        this.status = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.nomeAutor = getNomeAutor();
        this.curso = curso;

    }

    public void excluir() {
        this.status = false;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setId(Long topicoId) {
    }
}
