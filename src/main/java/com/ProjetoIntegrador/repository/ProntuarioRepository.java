package com.ProjetoIntegrador.repository;

import com.ProjetoIntegrador.model.Prontuario;
import com.ProjetoIntegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    List<Prontuario> findByCliente(Usuario cliente);
    List<Prontuario> findByClienteAndDataProntuarioBetween(Usuario cliente, LocalDate inicio, LocalDate fim);
    List<Prontuario> findByMedicoAndDataProntuarioBetween(Usuario medico, LocalDate inicio, LocalDate fim);
}