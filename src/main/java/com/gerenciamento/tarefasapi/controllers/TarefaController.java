package com.gerenciamento.tarefasapi.controllers;

import com.gerenciamento.tarefasapi.controllers.dtos.TarefaDTO;
import com.gerenciamento.tarefasapi.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarTarefa(@RequestBody @Valid TarefaDTO tarefaRequest) {
        tarefaService.cadastrar(tarefaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa cadastrada com sucesso! :)");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTodos() {
        List<TarefaDTO> tarefas = tarefaService.buscarTodos();
        return ResponseEntity.ok(tarefas);
    }

}
