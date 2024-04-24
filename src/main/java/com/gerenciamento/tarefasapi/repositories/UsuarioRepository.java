package com.gerenciamento.tarefasapi.repositories;

import com.gerenciamento.tarefasapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
