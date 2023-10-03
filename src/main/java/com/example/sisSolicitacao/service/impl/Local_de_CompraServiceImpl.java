package com.example.sisSolicitacao.service.impl;

import com.example.sisSolicitacao.dto.Local_de_CompraDTO;
import com.example.sisSolicitacao.entity.Local_de_compra;
import com.example.sisSolicitacao.repository.Local_de_CompraDao;
import com.example.sisSolicitacao.service.Local_de_CompraService;
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
public class Local_de_CompraServiceImpl implements Local_de_CompraService {
    @Autowired
    private Local_de_CompraDao localDeCompraDao;

    @Override
    public Page<Local_de_CompraDTO> findAll(Pageable pageable) {
        Page<Local_de_compra> list = localDeCompraDao.findAll(pageable);
        return list.map(x -> new Local_de_CompraDTO(x));
    }

    @Override
    public Local_de_CompraDTO findById(Long id) {
        Optional<Local_de_compra> o = localDeCompraDao.findById(id);
        Local_de_compra entity = o.orElseThrow(() -> new ResourceNotFoundException("Produto com ID: " + id + " não foi encontrado"));
        return new Local_de_CompraDTO(entity);
    }

    @Override
    public Local_de_CompraDTO insert(Local_de_CompraDTO dto) {
        Local_de_compra entity = new Local_de_compra();
        copyDtoToEntity(dto, entity);
        entity = localDeCompraDao.save(entity);
        return new Local_de_CompraDTO(entity);
    }

    @Override
    public Local_de_CompraDTO update(Long id, Local_de_CompraDTO dto) {
        try {
            Local_de_compra entity = localDeCompraDao.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = localDeCompraDao.save(entity);
            return new Local_de_CompraDTO(entity);
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

    private void copyDtoToEntity(Local_de_CompraDTO dto, Local_de_compra entity) {
        entity.setBairro(dto.getBairro());
        entity.setEndereco(dto.getEndereco());
        entity.setNome_estabelecimento(dto.getNome_estabelecimento());

    }
}