package com.ProjetoIntegrador.model;
import com.ProjetoIntegrador.enums.StatusCondicao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "condicoes_diarias")
public class CondicaoDiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario cliente;

    @Column(name = "data_condicao")
    private LocalDate dataCondicao;

    @Enumerated(EnumType.STRING)
    private StatusCondicao status;

    @Column(name = "avaliacao")
    private Short avaliacao;

    private String observacoes;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataCondicao() {
        return dataCondicao;
    }

    public void setDataCondicao(LocalDate dataCondicao) {
        this.dataCondicao = dataCondicao;
    }

    public StatusCondicao getStatus() {
        return status;
    }

    public void setStatus(StatusCondicao status) {
        this.status = status;
    }

    public short getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(short avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}

