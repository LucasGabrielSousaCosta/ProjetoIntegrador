package com.ProjetoIntegrador.repository;

import com.ProjetoIntegrador.model.CondicaoDiaria;
import com.ProjetoIntegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CondicaoDiariaRepository extends JpaRepository<CondicaoDiaria, Long> {
    Optional<CondicaoDiaria> findByClienteAndDataCondicao(Usuario cliente, LocalDate data);
    List<CondicaoDiaria> findByCliente(Usuario cliente);
}
