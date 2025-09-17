package com.ProjetoIntegrador.service;

import com.ProjetoIntegrador.model.CondicaoDiaria;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.repository.CondicaoDiariaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CondicaoDiariaService {

    private final CondicaoDiariaRepository repository;

    public CondicaoDiariaService(CondicaoDiariaRepository repository) {
        this.repository = repository;
    }

    public CondicaoDiaria salvar(CondicaoDiaria condicao) {
        return repository.save(condicao);
    }

    public Optional<CondicaoDiaria> buscarPorClienteData(Usuario cliente, LocalDate data) {
        return repository.findByClienteAndDataCondicao(cliente, data);
    }

    public List<CondicaoDiaria> listarPorCliente(Usuario cliente) {
        return repository.findByCliente(cliente);
    }
}
