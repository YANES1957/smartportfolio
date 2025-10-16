package com.roberto.smartportfolio.controller;

import com.roberto.smartportfolio.model.Investimento;
import com.roberto.smartportfolio.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    // Criar investimento (POST)
    @PostMapping
    public Investimento criar(@RequestBody Investimento investimento) {
        // A data de criação será setada automaticamente pelo Service
        return service.salvar(investimento);
    }

    // Listar todos os investimentos (GET)
    @GetMapping
    public List<Investimento> listar() {
        return service.listarTodos();
    }

    // Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Investimento> buscar(@PathVariable Long id) {
        Optional<Investimento> inv = service.buscarPorId(id);
        return inv.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar investimento (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Investimento> atualizar(@PathVariable Long id, @RequestBody Investimento investimento) {
        Optional<Investimento> existente = service.buscarPorId(id);
        if (existente.isPresent()) {
            investimento.setId(id);
            return ResponseEntity.ok(service.salvar(investimento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar investimento (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Investimento> existente = service.buscarPorId(id);
        if (existente.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
