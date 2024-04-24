package com.gerenciamento.tarefasapi.services;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.entities.Usuario;

public interface UsuarioService {

    Usuario cadastrar(UsuarioRequest usuarioRequest);
    Usuario buscarPorId(Long id);
}
