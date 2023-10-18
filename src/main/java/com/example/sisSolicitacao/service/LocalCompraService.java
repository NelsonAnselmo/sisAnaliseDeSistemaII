package com.example.sisSolicitacao.service;

import com.example.sisSolicitacao.dto.LocalCompraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocalCompraService {
    Page<LocalCompraDTO> findAll( Pageable pageable);

    LocalCompraDTO findById( Long id);

    LocalCompraDTO insert( LocalCompraDTO dto);

    LocalCompraDTO update( Long id, LocalCompraDTO dto);

    void delete(Long id);
}
