package com.example.sisSolicitacao.service.impl;

import com.example.sisSolicitacao.dto.ItemSolicitacaoDTO;
import com.example.sisSolicitacao.dto.SolicitacaoCompraDTO;
import com.example.sisSolicitacao.entity.ItensSolicitacao;
import com.example.sisSolicitacao.entity.Produto;
import com.example.sisSolicitacao.entity.SolicitacaoCompra;
import com.example.sisSolicitacao.repository.ItemSolicitacaoDao;
import com.example.sisSolicitacao.repository.ProdutoDao;
import com.example.sisSolicitacao.repository.SolicitacaoCompraDao;
import com.example.sisSolicitacao.service.SolicitacaoCompraService;
import com.example.sisSolicitacao.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SolicitacaoCompraServiceImpl implements SolicitacaoCompraService {

    @Autowired
    private SolicitacaoCompraDao solicitacaoCompraDao;

    @Autowired
    private ItemSolicitacaoDao itemSolicitacaoDao;

    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public Page<SolicitacaoCompraDTO> findAll( Pageable pageable ) {
        Page<SolicitacaoCompra> list = solicitacaoCompraDao.findAll(pageable);
        return list.map(x -> new SolicitacaoCompraDTO(x));
    }

    @Override
    public SolicitacaoCompraDTO findById(Long id) {
        Optional<SolicitacaoCompra> o = solicitacaoCompraDao.findById(id);
        SolicitacaoCompra entity = o.orElseThrow(() -> new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado"));
        return new SolicitacaoCompraDTO(entity);
    }

    @Override
    public SolicitacaoCompraDTO insert( SolicitacaoCompraDTO dto ) {

        SolicitacaoCompra solicitacao = new SolicitacaoCompra();
        solicitacao.setData_compra(dto.getData_compra());
        solicitacao.setEstatus(dto.getEstatus());
        solicitacaoCompraDao.save(solicitacao);

        for (ItemSolicitacaoDTO itemDTO : dto.getItensSolicitacao()) {

            Produto produto = produtoDao.findById(itemDTO.getProduto_id())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + itemDTO.getProduto_id()));

            ItensSolicitacao item = new ItensSolicitacao();
            item.setQuantidade(itemDTO.getQuantidade());
            item.setStatus(itemDTO.getStatus());
            item.setSolicitacaoCompra(solicitacao);
            item.setPreco_unitario(produto.getPreco());
            item.setProduto(produto);
            itemSolicitacaoDao.save(item);
        }

        return new SolicitacaoCompraDTO(solicitacao);
    }

    @Override
    public SolicitacaoCompraDTO update( Long id, SolicitacaoCompraDTO dto ) {
        return null;
    }

    @Override
    public void delete( Long id ) {

    }
}
