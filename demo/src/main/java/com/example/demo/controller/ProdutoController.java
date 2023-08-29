package com.example.demo.controller;

import com.example.demo.dto.ProdutoDto;
import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void salvar(@Valid @RequestBody ProdutoDto produtoDto) {
        produtoService.salvar(modelMapper.map(produtoDto, Produto.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProdutoDto> buscar() {
        return produtoService.buscar()
                .stream()
                .map(produto -> modelMapper.map(produto, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    ProdutoDto buscarId(@PathVariable(value = "idProduto") Long idProduto) {
        return modelMapper.map(produtoService.buscarId(idProduto), ProdutoDto.class);
    }

    @DeleteMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletar(@PathVariable(value = "idProduto") Long idProduto) {
        produtoService.deletar(idProduto);
    }

}