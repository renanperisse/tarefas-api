package com.gerenciamento.tarefasapi.controllers.dtos;

import com.gerenciamento.tarefasapi.entities.TarefaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public record TarefaDTO(@NotBlank(message = "O título deverá ser preenchido.")String titulo,
                        String descricao,
                        @DateTimeFormat(pattern = "dd/MM/yyyy")String dataDeCriacao,
                        @DateTimeFormat(pattern = "dd/MM/yyyy")String dataDeConclusao,
                        @NotNull(message = "O status da tarefa deverá ser preenchido.") TarefaStatus tarefaStatus,
                        @NotNull(message = "A tarefa deverá estar vinculada a um usuário.") Long usuarioId) {
}
