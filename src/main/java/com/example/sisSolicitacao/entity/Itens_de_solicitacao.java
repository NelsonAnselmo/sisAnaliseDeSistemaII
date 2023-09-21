package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name="Itens_de_solicitacao")

public class Itens_de_solicitacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Double preco_unitario;
    private Integer quantidade;
    private String status;

    public Itens_de_solicitacao() {
    }

    public Itens_de_solicitacao(Long id, Double preco_unitario, Integer quantidade) {
        this.id = id;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itens_de_solicitacao that = (Itens_de_solicitacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
