package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
  
  private List<Produto> produtos = new ArrayList<Produto>();

  private Integer ultimoId = 0;

  /**
   * Metodo para retornar uma lista de produtos
   * @return Lista de Produtos
   */

  public List<Produto> obterProdutos(){
    return produtos;
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu id
   * @param id do produto localizado.
   * @return retorna um produto caso encontrado
   */
  public Optional<Produto> obterPorId(Integer id){
    return produtos
      .stream().filter(produto -> produto.getId() == id)
      .findFirst();
  }

  /**
   * Metodo para adicionar produto na lista
   * @param produto que sera adicionado
   * @return retorna o produto adicionado na lista
   */
  public Produto adicionar(Produto produto){
    ultimoId++;
    produto.setId(ultimoId);
    produtos.add(produto);
    return produto;
  }

  /**
   * Metodo para deletar o produto por Id
   * @param id do produto deletado
   */
  public void deletar(Integer id){
    produtos.removeIf(produto -> produto.getId() == id);
  }

 /**
  * Metodo para atualizar produto na lista
  * @param produto adicionado na lista
  * @return retorna o produto atualizado
  */
  public Produto atualizar(Produto produto){
    //encontrar o produto na lista

    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

    if(produtoEncontrado.isEmpty()){
      throw new InputMismatchException("Produto não encontrado!");
    }

    //Remove produto da Lista
    deletar(produto.getId());

    //Adiciona produto atualizado
    produtos.add(produto);

    return produto;
  }
}
