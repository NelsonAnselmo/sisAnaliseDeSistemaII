package com.example.sisSolicitacao.dto;

import com.example.sisSolicitacao.entity.LocalCompra;

public class LocalCompraDTO {
    private Long id;
    private String bairro;
    private String endereco;
    private String nome_estabelecimento;

    public LocalCompraDTO() {
    }

    public LocalCompraDTO( Long id, String bairro, String endereco, String nome_estabelecimento) {
        this.id = id;
        this.bairro = bairro;
        this.endereco = endereco;
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public LocalCompraDTO( LocalCompra Entity) {
        id = Entity.getId();
        bairro = Entity.getBairro();
        endereco = Entity.getEndereco();
        nome_estabelecimento = Entity.getNome_estabelecimento();
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
}
