package com.gerenciamento.tarefasapi.repositories;

import com.gerenciamento.tarefasapi.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
