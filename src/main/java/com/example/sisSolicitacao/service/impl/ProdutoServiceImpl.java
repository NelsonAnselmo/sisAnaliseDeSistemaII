package com.example.sisSolicitacao.service.impl;

import com.example.sisSolicitacao.dto.ProdutoDTO;
import com.example.sisSolicitacao.entity.Produto;
import com.example.sisSolicitacao.repository.ProdutoDao;
import com.example.sisSolicitacao.service.ProdutoService;
import com.example.sisSolicitacao.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;
    @Override
    public Page<ProdutoDTO> findAll( Pageable pageable ) {
        Page<Produto> list = produtoDao.findAll(pageable);
        return list.map(x -> new ProdutoDTO(x));
    }

    @Override
    public ProdutoDTO findById(Long id) {
        Optional<Produto> o = produtoDao.findById(id);
        Produto entity = o.orElseThrow(() -> new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado"));
        return new ProdutoDTO(entity);
    }


    @Override
    public ProdutoDTO insert( ProdutoDTO dto ) {
        Produto entity = new Produto();
        copyDtoToEntity(dto, entity);
        entity = produtoDao.save(entity);
        return new ProdutoDTO(entity);
    }

    @Override
    public ProdutoDTO update( Long id, ProdutoDTO dto ) {
        try {
            Produto entity = produtoDao.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = produtoDao.save(entity);
            return new ProdutoDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado");
        }
    }
    @Override
    public void delete( Long id ) {
        try {
            produtoDao.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado");
        }catch (DataIntegrityViolationException e){
            throw new ResourceNotFoundException("Violacão de integridade da Base de Dados");
        }
    }

    private void copyDtoToEntity( ProdutoDTO dto, Produto entity ) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setMedida(dto.getMedida());
        entity.setPreco(dto.getPreco());
    }
}
