package com.ProjetoIntegrador.controller;

import com.ProjetoIntegrador.model.AtividadeConclusao;
import com.ProjetoIntegrador.model.AtividadeProntuario;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.service.AtividadeService;
import com.ProjetoIntegrador.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService service;
    private final UsuarioService usuarioService;

    public AtividadeController(AtividadeService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    // Listar atividades de um prontuário
    @GetMapping("/prontuario/{idProntuario}")
    public List<AtividadeProntuario> listarPorProntuario(@PathVariable Long idProntuario) {
        return service.listarPorProntuario(idProntuario);
    }

    // Marcar atividade como concluída pelo cliente
    @PostMapping("/concluir")
    public AtividadeConclusao marcarConcluida(@RequestBody AtividadeConclusao conclusao) {
        return service.marcarConcluida(conclusao);
    }

    // Listar todas conclusões de um cliente em uma data específica
    @GetMapping("/conclusoes/cliente/{idCliente}")
    public List<AtividadeConclusao> listarConclusoesPorClienteData(
            @PathVariable Long idCliente,
            @RequestParam String data) {

        Usuario cliente = usuarioService.buscarPorId(idCliente).orElseThrow();
        LocalDate dataConclusao = LocalDate.parse(data);
        return service.listarConclusoesPorClienteData(cliente, dataConclusao);
    }
}
