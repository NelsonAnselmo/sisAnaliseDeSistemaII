package com.example.sisSolicitacao.service;

import com.example.sisSolicitacao.dto.SolicitacaoCompraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolicitacaoCompraService {
    Page<SolicitacaoCompraDTO> findAll( Pageable pageable );

    SolicitacaoCompraDTO findById( Long id );

    SolicitacaoCompraDTO insert( SolicitacaoCompraDTO dto );

    SolicitacaoCompraDTO update( Long id, SolicitacaoCompraDTO dto );

    void delete( Long id );
}
