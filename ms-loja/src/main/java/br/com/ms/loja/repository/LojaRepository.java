package br.com.ms.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ms.loja.entity.Loja;

public interface LojaRepository extends PagingAndSortingRepository<Loja, Long>, JpaRepository<Loja, Long> {

}
