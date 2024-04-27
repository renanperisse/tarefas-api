package com.gerenciamento.tarefasapi.controllers;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioResponse;
import com.gerenciamento.tarefasapi.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        usuarioService.cadastrar(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso! :)");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        UsuarioResponse usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarTodos() {
        List<UsuarioResponse> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.atualizar(id, usuarioRequest);
        return ResponseEntity.ok().body("Usuário atualizado com sucesso. :)");
    }

}
