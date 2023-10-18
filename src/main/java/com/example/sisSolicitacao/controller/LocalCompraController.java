package com.example.sisSolicitacao.controller;

import com.example.sisSolicitacao.dto.LocalCompraDTO;
import com.example.sisSolicitacao.service.LocalCompraService;
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
@RequestMapping("/api/v1/local_Compra")
public class LocalCompraController {
    @Autowired
    private LocalCompraService service;

    @GetMapping
    public ResponseEntity<Page<LocalCompraDTO>> findAll( Pageable pageable){
        Page<LocalCompraDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalCompraDTO> findById( @PathVariable Long id){
        LocalCompraDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LocalCompraDTO> insert( @RequestBody LocalCompraDTO dto, HttpServletResponse response){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalCompraDTO> update( @PathVariable Long id , @RequestBody LocalCompraDTO dto, HttpServletResponse response){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocalCompraDTO> delete( @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
