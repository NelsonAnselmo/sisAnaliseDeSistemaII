package com.example.sisSolicitacao.service;

import com.example.sisSolicitacao.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
    Page<ProdutoDTO> findAll( Pageable pageable );

    ProdutoDTO findById( Long id );

    ProdutoDTO insert( ProdutoDTO dto );

    ProdutoDTO update( Long id, ProdutoDTO dto );

    void delete( Long id );
}
