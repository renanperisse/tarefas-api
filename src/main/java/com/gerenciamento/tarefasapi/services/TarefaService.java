package com.gerenciamento.tarefasapi.services;

import com.gerenciamento.tarefasapi.controllers.dtos.TarefaDTO;

import java.util.List;

public interface TarefaService {

    void cadastrar(TarefaDTO tarefaRequest);
    TarefaDTO buscarPorId(Long id);
    List<TarefaDTO> buscarTodos();

}
