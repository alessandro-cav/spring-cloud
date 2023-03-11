package br.com.ms.produto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.produto.entity.Produto;
import br.com.ms.produto.entity.ProdutoResponseDTO;
import br.com.ms.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository repository;

	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> buscarTodos() {

		List<ProdutoResponseDTO> produtoResponseDTO = this.repository.findAll().stream().map(produto -> {
			ProdutoResponseDTO proResponseDTO = new ProdutoResponseDTO();
			proResponseDTO.setId(produto.getId());
			proResponseDTO.setNome(produto.getNome());
			return proResponseDTO;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(produtoResponseDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> pesquisaId(@PathVariable(name = "id") Long id) {
		Produto produto = this.repository.findById(id).get();

		ProdutoResponseDTO proResponseDTO = new ProdutoResponseDTO();
		proResponseDTO.setId(produto.getId());
		proResponseDTO.setNome(produto.getNome());

		return ResponseEntity.ok(proResponseDTO);
	}

}
