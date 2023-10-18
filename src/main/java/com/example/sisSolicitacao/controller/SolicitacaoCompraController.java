package com.example.sisSolicitacao.controller;

import com.example.sisSolicitacao.dto.SolicitacaoCompraDTO;
import com.example.sisSolicitacao.service.SolicitacaoCompraService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/solicitacao_Compra")
public class SolicitacaoCompraController {

    @Autowired
    private SolicitacaoCompraService service;

    @GetMapping
    public ResponseEntity<Page<SolicitacaoCompraDTO>> findAll( Pageable pageable){
        Page<SolicitacaoCompraDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoCompraDTO> findById( @PathVariable Long id){
        SolicitacaoCompraDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SolicitacaoCompraDTO> insert( @RequestBody SolicitacaoCompraDTO dto, HttpServletResponse response){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitacaoCompraDTO> update( @PathVariable Long id , @RequestBody SolicitacaoCompraDTO dto, HttpServletResponse response){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SolicitacaoCompraDTO> delete( @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
