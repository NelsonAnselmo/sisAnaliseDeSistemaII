package com.example.sisSolicitacao.dto;

import com.example.sisSolicitacao.entity.Local_de_compra;

public class Local_de_CompraDTO {
    private Long id;
    private String bairro;
    private String endereco;
    private String nome_estabelecimento;

    public Local_de_CompraDTO() {
    }

    public Local_de_CompraDTO(Long id, String bairro, String endereco, String nome_estabelecimento) {
        this.id = id;
        this.bairro = bairro;
        this.endereco = endereco;
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public Local_de_CompraDTO(Local_de_compra Entity) {
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
