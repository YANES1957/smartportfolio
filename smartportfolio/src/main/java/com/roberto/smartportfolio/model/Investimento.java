package com.roberto.smartportfolio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "investimentos")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String risco;
    private Double rentabilidadeAnual;
    private String liquidez;
    private Double valorMinimo;
    private String descricao;
    private LocalDate dataCriacao;
    private Boolean favorito;

    // Construtor vazio (obrigatório para JPA)
    public Investimento() {
        this.dataCriacao = LocalDate.now();
    }

    // Construtor completo
    public Investimento(String nome, String tipo, String risco, Double rentabilidadeAnual,
                        String liquidez, Double valorMinimo, String descricao, Boolean favorito) {
        this.nome = nome;
        this.tipo = tipo;
        this.risco = risco;
        this.rentabilidadeAnual = rentabilidadeAnual;
        this.liquidez = liquidez;
        this.valorMinimo = valorMinimo;
        this.descricao = descricao;
        this.favorito = favorito;
        this.dataCriacao = LocalDate.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getRisco() { return risco; }
    public void setRisco(String risco) { this.risco = risco; }

    public Double getRentabilidadeAnual() { return rentabilidadeAnual; }
    public void setRentabilidadeAnual(Double rentabilidadeAnual) { this.rentabilidadeAnual = rentabilidadeAnual; }

    public String getLiquidez() { return liquidez; }
    public void setLiquidez(String liquidez) { this.liquidez = liquidez; }

    public Double getValorMinimo() { return valorMinimo; }
    public void setValorMinimo(Double valorMinimo) { this.valorMinimo = valorMinimo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public Boolean getFavorito() { return favorito; }
    public void setFavorito(Boolean favorito) { this.favorito = favorito; }
}
