package br.com.ms.user.responses;

import java.io.Serializable;

import br.com.ms.user.enuns.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsuarioResponseDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String login;

	@Enumerated(EnumType.STRING)
	private Status status;

	private PerfilResponseDTO perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PerfilResponseDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilResponseDTO perfil) {
		this.perfil = perfil;
	}
	
	
	

}
