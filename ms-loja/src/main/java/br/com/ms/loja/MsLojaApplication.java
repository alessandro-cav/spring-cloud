package br.com.ms.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsLojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLojaApplication.class, args);
	}

}
