package com.forumHub.forumHub.domain.usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forumHub.forumHub.domain.curso.Curso;
import com.forumHub.forumHub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    private boolean status;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "autor")
    @JsonBackReference
    private List<Topico> topicos = new ArrayList<>();

//    @OneToMany(mappedBy = "autor")
//    private List<Resposta> respostas = new ArrayList<>();

    public Usuario(DadosUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.status = true;
        this.curso = dados.curso();
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

       public void setSenha(String senha) {
        this.senha = senha;
    }
}

