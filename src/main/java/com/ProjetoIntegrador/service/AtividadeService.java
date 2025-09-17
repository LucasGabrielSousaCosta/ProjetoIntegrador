package com.ProjetoIntegrador.service;

import com.ProjetoIntegrador.model.AtividadeConclusao;
import com.ProjetoIntegrador.model.AtividadeProntuario;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.repository.AtividadeConclusaoRepository;
import com.ProjetoIntegrador.repository.AtividadeProntuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtividadeService {

    private final AtividadeProntuarioRepository atividadeRepository;
    private final AtividadeConclusaoRepository conclusaoRepository;

    public AtividadeService(AtividadeProntuarioRepository atividadeRepository,
                            AtividadeConclusaoRepository conclusaoRepository) {
        this.atividadeRepository = atividadeRepository;
        this.conclusaoRepository = conclusaoRepository;
    }

    public List<AtividadeProntuario> listarPorProntuario(Long idProntuario) {
        return atividadeRepository.findByProntuario(new AtividadeProntuario().getProntuario()); // ajustar depois
    }

    public AtividadeConclusao marcarConcluida(AtividadeConclusao conclusao) {
        return conclusaoRepository.save(conclusao);
    }

    public List<AtividadeConclusao> listarConclusoesPorClienteData(Usuario cliente, LocalDate data) {
        return conclusaoRepository.findByClienteAndDataConclusao(cliente, data);
    }
}