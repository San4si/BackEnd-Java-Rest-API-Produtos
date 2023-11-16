package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository produtoRepository;

   /**
   * Metodo para retornar uma lista de produtos
   * @return Lista de Produtos
   */
  public List<Produto> obterProdutos(){
    return produtoRepository.obterProdutos();
  }

   /**
   * Metodo que retorna o produto encontrado pelo seu id
   * @param id do produto localizado.
   * @return retorna um produto caso encontrado
   */
  public Optional<Produto> obterPorId(Integer id){
    return produtoRepository.obterPorId(id);
  }

    /**
   * Metodo para adicionar produto na lista
   * @param produto que sera adicionado
   * @return retorna o produto adicionado na lista
   */
  public Produto adicionar(Produto produto){
   return produtoRepository.adicionar(produto);
  }

    /**
   * Metodo para deletar o produto por Id
   * @param id do produto deletado
   */
  public void deletar(Integer id){
    produtoRepository.deletar(id);
  }

/**
  * Metodo para atualizar produto na lista
  * @param produto adicionado na lista
  * @return retorna o produto atualizado
  */
  public Produto atualizar(Integer id, Produto produto){

    produto.setId(id);

   return produtoRepository.atualizar(produto);
  }
}
