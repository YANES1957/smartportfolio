
package com.roberto.smartportfolio.service;

import com.roberto.smartportfolio.model.Investimento;
import com.roberto.smartportfolio.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository repository;

    // Salvar ou atualizar investimento
    public Investimento salvar(Investimento investimento) {
        // Se for novo investimento, define data de criação
        if (investimento.getId() == null) {
            investimento.setDataCriacao(LocalDate.now());
        }
        return repository.save(investimento);
    }

    // Listar todos os investimentos
    public List<Investimento> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<Investimento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Deletar investimento
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
