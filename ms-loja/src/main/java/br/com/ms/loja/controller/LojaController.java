package br.com.ms.loja.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.loja.entity.Loja;
import br.com.ms.loja.entity.Produto;
import br.com.ms.loja.feignclient.LojaFeignClient;
import br.com.ms.loja.repository.LojaRepository;
import br.com.ms.loja.repository.ProdutoRepository;
import br.com.ms.loja.requests.LojaRequestDTO;
import br.com.ms.loja.response.LojaResponseDTO;
import br.com.ms.loja.response.ProdutoResponseDTO;

@RestController
@RequestMapping("/lojas")
public class LojaController {

	private final LojaRepository repository;

	private final ProdutoRepository produtoRepository;

	private final LojaFeignClient lojaFeignClient;

	public LojaController(LojaRepository repository, ProdutoRepository produtoRepository,
			LojaFeignClient lojaFeignClient) {
		this.repository = repository;
		this.produtoRepository = produtoRepository;
		this.lojaFeignClient = lojaFeignClient;
	}

	@PostMapping
	public ResponseEntity<Loja> save(@RequestBody LojaRequestDTO lojaRequestDTO) {
		Produto produto = this.lojaFeignClient.pesquisaId(lojaRequestDTO.getIdProduto()).getBody();
		
		this.produtoRepository.save(produto);

		Loja loja = new Loja();
		loja.setLoja(lojaRequestDTO.getLoja());
		loja.setProduto(produto);

		loja = this.repository.save(loja);
		return ResponseEntity.ok(loja);
	}

	@GetMapping
	public ResponseEntity<List<LojaResponseDTO>> buscarTodos() {

		List<LojaResponseDTO> lojaResponse = this.repository.findAll().stream().map(loja -> {
			ProdutoResponseDTO proResponseDTO = new ProdutoResponseDTO();
			proResponseDTO.setId(loja.getProduto().getId());
			proResponseDTO.setNome(loja.getProduto().getNome());

			LojaResponseDTO lojaResponseDTO = new LojaResponseDTO();
			lojaResponseDTO.setId(loja.getId());
			lojaResponseDTO.setLoja(loja.getLoja());
			lojaResponseDTO.setProduto(proResponseDTO);

			return lojaResponseDTO;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(lojaResponse);
	}
}
