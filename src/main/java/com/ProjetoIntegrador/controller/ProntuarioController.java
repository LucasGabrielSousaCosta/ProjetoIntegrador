package com.ProjetoIntegrador.controller;

import com.ProjetoIntegrador.model.Prontuario;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.service.ProntuarioService;
import com.ProjetoIntegrador.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;
    private final UsuarioService usuarioService;

    public ProntuarioController(ProntuarioService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Prontuario> listarPorCliente(@PathVariable Long idCliente) {
        Usuario cliente = usuarioService.buscarPorId(idCliente).orElseThrow();
        return service.listarPorCliente(cliente);
    }

    @GetMapping("/cliente/{idCliente}/mes")
    public List<Prontuario> listarPorClienteMes(
            @PathVariable Long idCliente,
            @RequestParam String inicio,
            @RequestParam String fim) {

        Usuario cliente = usuarioService.buscarPorId(idCliente).orElseThrow();
        LocalDate inicioData = LocalDate.parse(inicio);
        LocalDate fimData = LocalDate.parse(fim);
        return service.listarPorClienteMes(cliente, inicioData, fimData);
    }
}