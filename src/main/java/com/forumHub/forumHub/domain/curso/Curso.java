package com.forumHub.forumHub.domain.curso;

import com.forumHub.forumHub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    //@OneToMany(mappedBy = "curso")
    //private List<Topico> topicos = new ArrayList<>();

    public Curso(String nomeCurso) {
        this.nome = nomeCurso;
    }
}