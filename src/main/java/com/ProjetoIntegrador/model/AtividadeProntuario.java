package com.ProjetoIntegrador.model;

import com.ProjetoIntegrador.enums.TipoAtividade;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "atividades_prontuario")
public class AtividadeProntuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_prontuario", nullable = false)
    private Prontuario prontuario;

    @Enumerated(EnumType.STRING)
    private TipoAtividade tipo;

    private String descricao;

    @Column(name = "sugerido_quando")
    private String sugeridoQuando;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public TipoAtividade getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtividade tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSugeridoQuando() {
        return sugeridoQuando;
    }

    public void setSugeridoQuando(String sugeridoQuando) {
        this.sugeridoQuando = sugeridoQuando;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}

