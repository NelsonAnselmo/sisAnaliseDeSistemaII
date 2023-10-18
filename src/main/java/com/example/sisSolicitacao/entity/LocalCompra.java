package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name="local_compra")
public class LocalCompra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String endereco;
    private String nome_estabelecimento;

    @ManyToMany(mappedBy = "locaisDeCompra")
    private Set<ItensSolicitacao> itensDeCompra = new HashSet<>();

    public LocalCompra() {
    }

    public LocalCompra( Long id, String bairro, String endereco, String nome_estabelecimento) {
        this.id = id;
        this.bairro = bairro;
        this.endereco = endereco;
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome_estabelecimento() {
        return nome_estabelecimento;
    }

    public void setNome_estabelecimento(String nome_estabelecimento) {
        this.nome_estabelecimento = nome_estabelecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalCompra that = (LocalCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
