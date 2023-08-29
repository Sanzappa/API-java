package com.example.demo.service;

import com.example.demo.dto.ProdutoDto;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    public List<Produto> buscar() {
        return produtoRepository.findAll();
    }

    public Produto buscarId(Long idProduto) { return produtoRepository.findById(idProduto).orElseThrow();}

    public void deletar(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }
}