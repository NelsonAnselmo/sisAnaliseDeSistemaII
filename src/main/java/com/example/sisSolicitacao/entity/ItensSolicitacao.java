package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name="itens_solicitacao")
public class ItensSolicitacao {

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
    private Set<LocalCompra> locaisDeCompra = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoCompra solicitacaoCompra;


    public ItensSolicitacao() {
    }

    public ItensSolicitacao( Long id, Double preco_unitario, Integer quantidade, Produto produto, SolicitacaoCompra solicitacaoCompra) {
        this.id = id;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.produto = produto;
        this.solicitacaoCompra = solicitacaoCompra;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto( Produto produto ) {
        this.produto = produto;
    }

    public SolicitacaoCompra getSolicitacaoCompra() {
        return solicitacaoCompra;
    }

    public void setSolicitacaoCompra( SolicitacaoCompra solicitacaoCompra ) {
        this.solicitacaoCompra = solicitacaoCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensSolicitacao that = (ItensSolicitacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
