package com.example.sisSolicitacao.entity;

import com.example.sisSolicitacao.enums.Estatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name="solicitacao_compra")
public class SolicitacaoCompra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data_compra;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    @OneToMany(mappedBy = "solicitacaoCompra")
    private Set<ItensSolicitacao> itensSolicitacao = new HashSet<>();

    @OneToMany(mappedBy = "solicitacaoCompra")
    private Set<Compra> compras = new HashSet<>();

    public SolicitacaoCompra() {
    }

    public SolicitacaoCompra( Long id, Date data_compra) {
        this.id = id;
        this.data_compra = data_compra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus( Estatus estatus ) {
        this.estatus = estatus;
    }

    public void setData_compra( Date data_compra) {
        this.data_compra = data_compra;
    }

    public Set<ItensSolicitacao> getItensSolicitacao() {
        return itensSolicitacao;
    }

    public void setItensSolicitacao( Set<ItensSolicitacao> itensDeSolicitacao ) {
        this.itensSolicitacao = itensDeSolicitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoCompra that = (SolicitacaoCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}