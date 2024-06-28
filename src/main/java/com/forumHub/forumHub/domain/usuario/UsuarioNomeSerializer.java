package com.forumHub.forumHub.domain.usuario;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


import java.io.IOException;

public class UsuarioNomeSerializer extends JsonSerializer<Usuario> {

    @Override
    public void serialize(Usuario usuario, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(usuario.getNome());
    }
}