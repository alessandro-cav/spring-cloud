package br.com.ms.loja.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ms.loja.entity.Produto;


@Component
@FeignClient(name = "ms-produto",path = "/produtos")
public interface LojaFeignClient {
	
	@GetMapping("/{id}")
	ResponseEntity<Produto> pesquisaId(@PathVariable(name = "id") Long id);

}
