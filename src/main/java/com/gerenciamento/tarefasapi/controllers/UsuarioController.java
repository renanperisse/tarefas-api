package com.gerenciamento.tarefasapi.controllers;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioResponse;
import com.gerenciamento.tarefasapi.entities.Usuario;
import com.gerenciamento.tarefasapi.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.cadastrar(usuarioRequest);
        return ResponseEntity.created(URI.create("/usuarios/" + usuario.getId())).build();
    }

}
