package com.ProjetoIntegrador.repository;

import com.ProjetoIntegrador.model.AtividadeProntuario;
import com.ProjetoIntegrador.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AtividadeProntuarioRepository extends JpaRepository<AtividadeProntuario, Long> {
    List<AtividadeProntuario> findByProntuario(Prontuario prontuario);
}
