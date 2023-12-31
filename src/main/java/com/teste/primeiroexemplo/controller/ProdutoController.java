package com.teste.primeiroexemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.services.ProdutoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
  
  @Autowired
  private ProdutoService produtoService;
  
  @GetMapping
  public List<Produto> obterProdutos(){
    return produtoService.obterProdutos();
  }

  @PostMapping
  public Produto adicionar(@RequestBody Produto produto){
    return produtoService.adicionar(produto);
  }

  @GetMapping("/{id}")
  public Optional<Produto> obterPorId(@PathVariable Integer id){
    return produtoService.obterPorId(id);
  }

  /**
   * 
   */
  @DeleteMapping("/{id}")
  public String deletar(@PathVariable Integer id){
    produtoService.deletar(id);
    return "O produto com Id: " + id + " foi deletado com sucesso";
  }




}
