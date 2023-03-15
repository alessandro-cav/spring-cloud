package br.com.ms.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.user.entities.Usuario;
import br.com.ms.user.repositories.UsuarioRepository;
import br.com.ms.user.responses.PerfilResponseDTO;
import br.com.ms.user.responses.UsuarioResponseDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioRepository repository;

	public UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> pesquisaId(@PathVariable(name = "id") Long id) {
		Usuario usuario = this.repository.findById(id).get();

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
	
	
	@GetMapping(value = "/search")
	public ResponseEntity<UsuarioResponseDTO> pesquisaLogin(@RequestParam String login) {
		Usuario usuario = this.repository.findByLogin(login).get();

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
