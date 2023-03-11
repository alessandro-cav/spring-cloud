package br.com.ms.loja.response;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LojaResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String loja;

	private ProdutoResponseDTO produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public ProdutoResponseDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoResponseDTO produto) {
		this.produto = produto;
	}

}
