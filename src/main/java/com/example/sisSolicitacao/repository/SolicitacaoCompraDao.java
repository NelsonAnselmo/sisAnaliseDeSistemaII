package com.example.sisSolicitacao.repository;

import com.example.sisSolicitacao.entity.SolicitacaoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoCompraDao extends JpaRepository<SolicitacaoCompra, Long> {
}
