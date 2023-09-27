package com.example.sisSolicitacao.dto;

import com.example.sisSolicitacao.entity.Produto;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer medida;

    public ProdutoDTO() {
    }

    public ProdutoDTO( Long id, String nome, String descricao, Double preco, Integer medida ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.medida = medida;
    }

    public ProdutoDTO( Produto entity ) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        preco = entity.getPreco();
        medida = entity.getMedida();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco( Double preco ) {
        this.preco = preco;
    }

    public Integer getMedida() {
        return medida;
    }

    public void setMedida( Integer medida ) {
        this.medida = medida;
    }
}
