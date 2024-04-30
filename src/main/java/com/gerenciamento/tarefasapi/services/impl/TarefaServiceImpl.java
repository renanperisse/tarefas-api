package com.gerenciamento.tarefasapi.services.impl;

import com.gerenciamento.tarefasapi.controllers.dtos.TarefaDTO;
import com.gerenciamento.tarefasapi.entities.Tarefa;
import com.gerenciamento.tarefasapi.exceptions.UsuarioNaoEncontradoException;
import com.gerenciamento.tarefasapi.repositories.TarefaRepository;
import com.gerenciamento.tarefasapi.services.TarefaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    private static final String USUARIO_NAO_ENCONTRADO_MSG = "Não temos um usuário com este ID informado.";

    @Override
    public void cadastrar(TarefaDTO tarefaRequest) {
        Tarefa tarefa = new Tarefa(tarefaRequest.titulo(), tarefaRequest.descricao(), tarefaRequest.dataDeCriacao(),tarefaRequest.dataDeConclusao(), tarefaRequest.tarefaStatus(), tarefaRequest.usuarioId());
        tarefaRepository.save(tarefa);
    }

    @Override
    public TarefaDTO buscarPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(USUARIO_NAO_ENCONTRADO_MSG));
        return new TarefaDTO(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataDeCriacao(), tarefa.getDataDeConclusao(), tarefa.getTarefaStatus(), tarefa.getUsuario().getId());
    }

    @Override
    public List<TarefaDTO> buscarTodos() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream().map(tarefa ->
                new TarefaDTO(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataDeCriacao(), tarefa.getDataDeConclusao(), tarefa.getTarefaStatus(),tarefa.getUsuario().getId())).collect(Collectors.toList());
    }
}
