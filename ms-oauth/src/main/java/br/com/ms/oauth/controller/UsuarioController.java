package br.com.ms.oauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.oauth.entities.Usuario;
import br.com.ms.oauth.responses.PerfilResponseDTO;
import br.com.ms.oauth.responses.UsuarioResponseDTO;
import br.com.ms.oauth.services.UsuarioService;


@RestController
@RequestMapping("/usuarios1")
public class UsuarioController {

	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@GetMapping(value = "/search")
	public ResponseEntity<UsuarioResponseDTO> pesquisaLogin(@RequestParam String login) {
		Usuario usuario = this.service.findByLogin(login);

		PerfilResponseDTO perfilResponseDTO = new PerfilResponseDTO();
		perfilResponseDTO.setId(usuario.getPerfil().getId());
		perfilResponseDTO.setNome(usuario.getPerfil().getNome());

		UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
		usuarioResponseDTO.setId(usuario.getId());
		usuarioResponseDTO.setLogin(usuario.getLogin());
		usuarioResponseDTO.setStatus(usuario.getStatus());
		usuarioResponseDTO.setPerfil(perfilResponseDTO);

		return ResponseEntity.ok(usuarioResponseDTO);
	}
	
}
