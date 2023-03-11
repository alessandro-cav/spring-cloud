package br.com.ms.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ms.produto.entity.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>, JpaRepository<Produto, Long> {

}
