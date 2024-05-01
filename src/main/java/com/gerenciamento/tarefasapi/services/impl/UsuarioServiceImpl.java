package com.gerenciamento.tarefasapi.services.impl;

import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioRequest;
import com.gerenciamento.tarefasapi.controllers.dtos.UsuarioResponse;
import com.gerenciamento.tarefasapi.entities.Usuario;
import com.gerenciamento.tarefasapi.exceptions.UsuarioNaoEncontradoException;
import com.gerenciamento.tarefasapi.repositories.UsuarioRepository;
import com.gerenciamento.tarefasapi.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private static final String USUARIO_NAO_ENCONTRADO_MSG = "Não temos um usuário com este ID informado.";

    @Override
    public void cadastrar(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest.nome(),usuarioRequest.email(), usuarioRequest.senha());
        usuarioRepository.save(usuario);
        }

    @Override
    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(USUARIO_NAO_ENCONTRADO_MSG));
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    @Override
    public List<UsuarioResponse> buscarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario ->
                new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail())).collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(USUARIO_NAO_ENCONTRADO_MSG));
        usuarioRepository.delete(usuario);
    }

    @Override
    public void atualizar(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(USUARIO_NAO_ENCONTRADO_MSG));
        BeanUtils.copyProperties(usuarioRequest, usuario, "id");
        usuarioRepository.save(usuario);
    }


}
