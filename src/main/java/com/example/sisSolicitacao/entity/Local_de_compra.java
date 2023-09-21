package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name="Local_de_compra")
public class Local_de_compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String endereco;
    private String nome_estabelecimento;

    public Local_de_compra() {
    }

    public Local_de_compra(Long id, String bairro, String endereco, String nome_estabelecimento) {
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
        Local_de_compra that = (Local_de_compra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
