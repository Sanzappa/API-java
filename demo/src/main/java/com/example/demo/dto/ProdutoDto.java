package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
public class ProdutoDto {
    private Long idProduto;
    private String cpfUsuario;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    private String foto;
}