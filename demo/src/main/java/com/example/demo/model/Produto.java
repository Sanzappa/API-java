package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "t_produto")
@Data
public class Produto {
    @Id
    private Long idProduto;
    private String cpfUsuario;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    private String foto;
}