package com.ProjetoIntegrador.controller;

import com.ProjetoIntegrador.model.CondicaoDiaria;
import com.ProjetoIntegrador.model.Usuario;
import com.ProjetoIntegrador.service.CondicaoDiariaService;
import com.ProjetoIntegrador.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/condicoes")
public class CondicaoDiariaController {

    private final CondicaoDiariaService service;
    private final UsuarioService usuarioService;

    public CondicaoDiariaController(CondicaoDiariaService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    // Registrar condição diária
    @PostMapping
    public CondicaoDiaria registrar(@RequestBody CondicaoDiaria condicao) {
        return service.salvar(condicao);
    }

    // Buscar condição diária de um cliente por data
    @GetMapping("/cliente/{idCliente}/data")
    public Optional<CondicaoDiaria> buscarPorData(
            @PathVariable Long idCliente,
            @RequestParam String data) {

        Usuario cliente = usuarioService.buscarPorId(idCliente).orElseThrow();
        LocalDate dataCondicao = LocalDate.parse(data);
        return service.buscarPorClienteData(cliente, dataCondicao);
    }

    // Listar todas condições de um cliente
    @GetMapping("/cliente/{idCliente}")
    public List<CondicaoDiaria> listarPorCliente(@PathVariable Long idCliente) {
        Usuario cliente = usuarioService.buscarPorId(idCliente).orElseThrow();
        return service.listarPorCliente(cliente);
    }
}
