package com.example.sisSolicitacao.repository;

import com.example.sisSolicitacao.entity.ItensSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSolicitacaoDao extends JpaRepository<ItensSolicitacao, Long> {
}
