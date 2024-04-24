package com.gerenciamento.tarefasapi.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest (
        @NotBlank(message = "O nome deverá ser preenchido.")
        @Size(min = 3, max = 50, message = "O nome deverá ter no mínimo 3 letras e no máximo 50.") String nome,

        @NotBlank(message = "O email deverá ser preenchido.")
        @Email(message = "O e-mail deve ser válido.")String email,

        @NotBlank(message = "A senha deverá ser preenchida.")
        @Size(min = 5, max = 15, message = "A senha deverá ter no mínimo 5 letras e no máximo 15.") String senha) {
}
