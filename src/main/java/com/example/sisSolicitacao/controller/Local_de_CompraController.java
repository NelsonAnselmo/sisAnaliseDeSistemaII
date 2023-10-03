package com.example.sisSolicitacao.controller;

import com.example.sisSolicitacao.dto.Local_de_CompraDTO;
import com.example.sisSolicitacao.service.Local_de_CompraService;
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
public class Local_de_CompraController {
    @Autowired
    private Local_de_CompraService service;

    @GetMapping
    public ResponseEntity<Page<Local_de_CompraDTO>> findAll(Pageable pageable){
        Page<Local_de_CompraDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local_de_CompraDTO> findById( @PathVariable Long id){
        Local_de_CompraDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Local_de_CompraDTO> insert( @RequestBody Local_de_CompraDTO dto, HttpServletResponse response){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local_de_CompraDTO> update( @PathVariable Long id , @RequestBody Local_de_CompraDTO dto, HttpServletResponse response){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Local_de_CompraDTO> delete( @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
