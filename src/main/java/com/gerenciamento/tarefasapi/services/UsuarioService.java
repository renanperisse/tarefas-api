package com.gerenciamento.tarefasapi.services;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    void cadastrar(UsuarioRequest usuarioRequest);
    UsuarioResponse buscarPorId(Long id);
    List<UsuarioResponse> buscarTodos();
    void deletar(Long id);
    void atualizar(Long id, UsuarioRequest usuarioRequest);
}
