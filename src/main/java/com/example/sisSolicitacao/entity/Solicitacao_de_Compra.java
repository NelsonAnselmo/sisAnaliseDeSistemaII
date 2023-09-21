package com.example.sisSolicitacao.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table (name="Solicitacao_Compra")
public class Solicitacao_de_Compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data_compra;
    private String status;

    public Solicitacao_de_Compra() {
    }

    public Solicitacao_de_Compra(Long id, Date data_compra) {
        this.id = id;
        this.data_compra = data_compra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitacao_de_Compra that = (Solicitacao_de_Compra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}