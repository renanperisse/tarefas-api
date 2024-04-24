package com.gerenciamento.tarefasapi.services.impl;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.entities.Usuario;
import com.gerenciamento.tarefasapi.exceptions.UsuarioNaoEncontradoException;
import com.gerenciamento.tarefasapi.repositories.UsuarioRepository;
import com.gerenciamento.tarefasapi.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario cadastrar(UsuarioRequest usuarioRequest) {
        return usuarioRepository.save(new Usuario(usuarioRequest.nome(), usuarioRequest.email(), usuarioRequest.senha()));
        }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("O usuário não foi encontrado com o ID: " + id));

    }


}
