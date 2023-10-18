package com.example.sisSolicitacao.dto;

import com.example.sisSolicitacao.entity.ItensSolicitacao;

public class ItemSolicitacaoDTO {
    private long id;
    private Double preco_unitario;
    private Integer quantidade;
    private String status;
    private Long solicitacao_id;
    private Long produto_id;

    public ItemSolicitacaoDTO() {
    }

    public ItemSolicitacaoDTO( Long id, Double preco_unitario, Integer quantidade, String status, Long solicitacao_id, Long produto_id ) {
        this.id = id;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.status = status;
        this.solicitacao_id = solicitacao_id;
        this.produto_id = produto_id;
    }

    public ItemSolicitacaoDTO( ItensSolicitacao entity ) {
        id = entity.getId();
        preco_unitario = entity.getPreco_unitario();
        quantidade = entity.getQuantidade();
        status = entity.getStatus();
        solicitacao_id = entity.getSolicitacaoCompra().getId();
        produto_id = entity.getProduto().getId();

    }

    public Double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario( Double preco_unitario ) {
        this.preco_unitario = preco_unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade( Integer quantidade ) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Long getSolicitacao_id() {
        return solicitacao_id;
    }

    public void setSolicitacao_id( Long solicitacao_id ) {
        this.solicitacao_id = solicitacao_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id( Long produto_id ) {
        this.produto_id = produto_id;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }
}
