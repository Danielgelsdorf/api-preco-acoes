package br.com.gelsdorf.apiacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiAcoesApplication {

	public static void main(String[] args)
	{
		System.setProperty("server.port", "80");
		SpringApplication.run(ApiAcoesApplication.class, args);
	}

}
