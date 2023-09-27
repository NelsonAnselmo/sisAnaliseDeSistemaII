package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name="itens_solicitacao")
public class Itens_de_solicitacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Double preco_unitario;
    private Integer quantidade;
    private String status;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToMany
    @JoinTable(
            name = "item_local_compra",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id"))
    private Set<Local_de_compra> locaisDeCompra = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private Solicitacao_de_Compra solicitacaoCompra;


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
