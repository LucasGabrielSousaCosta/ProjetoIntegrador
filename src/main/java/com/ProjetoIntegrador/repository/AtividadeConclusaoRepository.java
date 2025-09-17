package com.ProjetoIntegrador.repository;

import com.ProjetoIntegrador.model.AtividadeConclusao;
import com.ProjetoIntegrador.model.AtividadeProntuario;
import com.ProjetoIntegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AtividadeConclusaoRepository extends JpaRepository<AtividadeConclusao, Long> {
    List<AtividadeConclusao> findByClienteAndDataConclusao(Usuario cliente, LocalDate data);
    List<AtividadeConclusao> findByAtividadeInAndCliente(List<AtividadeProntuario> atividades, Usuario cliente);
}