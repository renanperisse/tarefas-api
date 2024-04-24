package com.gerenciamento.tarefasapi.entities;

import jakarta.persistence.*;

@Entity(name = "TB_TAREFA")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descricao;
    private String dataDeCriacao;
    private String dataDeConclusao;

    private TarefaStatus tarefaStatus;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, String dataDeCriacao, String dataDeConclusao, TarefaStatus tarefaStatus, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeCriacao = dataDeCriacao;
        this.dataDeConclusao = dataDeConclusao;
        this.tarefaStatus = tarefaStatus;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TarefaStatus getTarefaStatus() {
        return tarefaStatus;
    }

    public void setTarefaStatus(TarefaStatus tarefaStatus) {
        this.tarefaStatus = tarefaStatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataDeConclusao() {
        return dataDeConclusao;
    }

    public void setDataDeConclusao(String dataDeConclusao) {
        this.dataDeConclusao = dataDeConclusao;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
