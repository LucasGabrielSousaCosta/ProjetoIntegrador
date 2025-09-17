package com.ProjetoIntegrador.service;

import com.ProjetoIntegrador.model.Prontuario;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository) {
        this.prontuarioRepository = prontuarioRepository;
    }

    public Prontuario salvar(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> listarPorCliente(Usuario cliente) {
        return prontuarioRepository.findByCliente(cliente);
    }

    public List<Prontuario> listarPorClienteMes(Usuario cliente, LocalDate inicio, LocalDate fim) {
        return prontuarioRepository.findByClienteAndDataProntuarioBetween(cliente, inicio, fim);
    }

    public List<Prontuario> listarPorMedicoMes(Usuario medico, LocalDate inicio, LocalDate fim) {
        return prontuarioRepository.findByMedicoAndDataProntuarioBetween(medico, inicio, fim);
    }
}