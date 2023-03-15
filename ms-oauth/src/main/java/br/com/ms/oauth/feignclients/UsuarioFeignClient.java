package br.com.ms.oauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ms.oauth.responses.UsuarioResponseDTO;

@Component
@FeignClient(name = "ms-user", path = "/usuarios")
public interface UsuarioFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<UsuarioResponseDTO> pesquisaLogin(@RequestParam String login);
}
