package com.example.sisSolicitacao.service;

import com.example.sisSolicitacao.dto.Local_de_CompraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Local_de_CompraService {
    Page<Local_de_CompraDTO> findAll(Pageable pageable);

    Local_de_CompraDTO findById(Long id);

    Local_de_CompraDTO insert(Local_de_CompraDTO dto);

    Local_de_CompraDTO update(Long id, Local_de_CompraDTO dto);

    void delete(Long id);
}
