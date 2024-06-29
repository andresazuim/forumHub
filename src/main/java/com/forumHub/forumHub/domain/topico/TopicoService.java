package com.forumHub.forumHub.domain.topico;

import com.forumHub.forumHub.domain.curso.Curso;
import com.forumHub.forumHub.domain.curso.CursoRepository;
import com.forumHub.forumHub.domain.usuario.Usuario;
import com.forumHub.forumHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico criarTopico(DadosTopicos dados) {

        if (topicoRepository.existsByTitulo(dados.titulo()) && topicoRepository.existsByMensagem(dados.mensagem())) {
            throw new IllegalArgumentException("Combinação de Título e Mensagem já existe.");
        }

        Optional<Usuario> autor = usuarioRepository.findById(Long.valueOf(dados.autorId()));
        var nomeAutor = autor.stream().findAny().get().getNome();

        if (!autor.isPresent()) {
            throw new IllegalArgumentException("Autor não encontrado: Nenhum usuário com o ID fornecido foi encontrado.");
        }

        Usuario autorGet = autor.get();
        Curso curso = autorGet.getCurso();

        Topico novoTopico = new Topico(dados);
        novoTopico.setNomeAutor(nomeAutor);
        novoTopico.setCurso(curso);

        return topicoRepository.save(novoTopico);

    }

    public List<Topico> listaTopico() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> listaTopicoID(Long topicoId) {
        return topicoRepository.findById(topicoId);
    }


    // Método para deletar um tópico
//    public void deletarTopico(Long id) {
//        Optional<Topico> topico = topicoRepository.findById(id);
//
//        if (topico.isEmpty()) {
//            throw new IllegalArgumentException("Tópico não encontrado: Nenhum tópico com o ID fornecido foi encontrado.");
//        }
//
//        topicoRepository.delete(topico.get());
//    }
}
