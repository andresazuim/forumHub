package com.forumHub.forumHub.domain.perfil;

import com.forumHub.forumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "perfil")
@Table(name= "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //@ManyToMany(mappedBy = "perfis")
    //private Set<Usuario> usuarios = new HashSet<>();

}