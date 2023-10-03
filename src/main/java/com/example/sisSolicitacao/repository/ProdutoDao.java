package com.example.sisSolicitacao.repository;

import com.example.sisSolicitacao.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {

}
