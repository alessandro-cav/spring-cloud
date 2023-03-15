package br.com.ms.oauth.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ms.oauth.entities.Perfil;
import br.com.ms.oauth.entities.Usuario;
import br.com.ms.oauth.feignclients.UsuarioFeignClient;
import br.com.ms.oauth.responses.UsuarioResponseDTO;

@Service
public class UsuarioService {

	private final UsuarioFeignClient feignClient;

	public UsuarioService(UsuarioFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	public Usuario findByLogin(String login) {

		UsuarioResponseDTO usuarioResponse = this.feignClient.pesquisaLogin(login).getBody();

		if (usuarioResponse == null) {
			throw new RuntimeException("Login invalido");
		}

		Perfil perfil = new Perfil();
		perfil.setId(usuarioResponse.getPerfil().getId());
		perfil.setNome(usuarioResponse.getPerfil().getNome());

		Usuario usuario = new Usuario();
		usuario.setId(usuarioResponse.getId());
		usuario.setLogin(usuarioResponse.getLogin());
		usuario.setStatus(usuario.getStatus());
		usuario.setPerfil(perfil);
		return usuario;

	}

}
