package com.example.sisSolicitacao.dto;

import com.example.sisSolicitacao.entity.ItensSolicitacao;
import com.example.sisSolicitacao.entity.SolicitacaoCompra;
import com.example.sisSolicitacao.enums.Estatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SolicitacaoCompraDTO {

    private Long id;
    private Date data_compra;
    private Estatus estatus;
    private Set<ItemSolicitacaoDTO> itensSolicitacao = new HashSet<>();

    public SolicitacaoCompraDTO() {
    }

    public SolicitacaoCompraDTO( Long id, Date data_compra, Estatus estatus ) {
        this.data_compra = data_compra;
        this.estatus = estatus;
        this.id = id;
    }

    public SolicitacaoCompraDTO( SolicitacaoCompra entity ) {
        data_compra = entity.getData_compra();
        estatus = entity.getEstatus();
        id = entity.getId();
        itensSolicitacao = convertItemToDTOs(entity.getItensSolicitacao());
    }

    private Set<ItemSolicitacaoDTO> convertItemToDTOs(Set<ItensSolicitacao> itens) {
        Set<ItemSolicitacaoDTO> itemDTOs = new HashSet<>();

        for (ItensSolicitacao item : itens) {
            ItemSolicitacaoDTO dto = new ItemSolicitacaoDTO();
            dto.setId(item.getId());
            dto.setSolicitacao_id(item.getSolicitacaoCompra().getId());
            dto.setPreco_unitario(item.getPreco_unitario());
            dto.setQuantidade(item.getQuantidade());
            dto.setStatus(item.getStatus());
            dto.setProduto_id(item.getProduto().getId());
            itemDTOs.add(dto);
        }

        return itemDTOs;
    }




    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra( Date data_compra ) {
        this.data_compra = data_compra;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus( Estatus estatus ) {
        this.estatus = estatus;
    }

    public Set<ItemSolicitacaoDTO> getItensSolicitacao() {
        return itensSolicitacao;
    }

}
