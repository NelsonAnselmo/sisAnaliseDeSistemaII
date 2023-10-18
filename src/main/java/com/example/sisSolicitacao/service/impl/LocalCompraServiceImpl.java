package com.example.sisSolicitacao.service.impl;

import com.example.sisSolicitacao.dto.LocalCompraDTO;
import com.example.sisSolicitacao.entity.LocalCompra;
import com.example.sisSolicitacao.repository.LocalCompraDao;
import com.example.sisSolicitacao.service.LocalCompraService;
import com.example.sisSolicitacao.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class LocalCompraServiceImpl implements LocalCompraService {
    @Autowired
    private LocalCompraDao localDeCompraDao;

    @Override
    public Page<LocalCompraDTO> findAll( Pageable pageable) {
        Page<LocalCompra> list = localDeCompraDao.findAll(pageable);
        return list.map(x -> new LocalCompraDTO(x));
    }

    @Override
    public LocalCompraDTO findById( Long id) {
        Optional<LocalCompra> o = localDeCompraDao.findById(id);
        LocalCompra entity = o.orElseThrow(() -> new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado"));
        return new LocalCompraDTO(entity);
    }

    @Override
    public LocalCompraDTO insert( LocalCompraDTO dto) {
        LocalCompra entity = new LocalCompra();
        copyDtoToEntity(dto, entity);
        entity = localDeCompraDao.save(entity);
        return new LocalCompraDTO(entity);
    }

    @Override
    public LocalCompraDTO update( Long id, LocalCompraDTO dto) {
        try {
            LocalCompra entity = localDeCompraDao.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = localDeCompraDao.save(entity);
            return new LocalCompraDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Local de Compra com ID: " + id + " não foi encontrado");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            localDeCompraDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Local de Compra com ID: " + id + " não foi encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new ResourceNotFoundException("Violacão de integridade da Base de Dados");
        }
    }

    private void copyDtoToEntity( LocalCompraDTO dto, LocalCompra entity) {
        entity.setBairro(dto.getBairro());
        entity.setEndereco(dto.getEndereco());
        entity.setNome_estabelecimento(dto.getNome_estabelecimento());

    }
}