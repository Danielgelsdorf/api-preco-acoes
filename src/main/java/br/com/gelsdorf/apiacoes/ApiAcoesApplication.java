package br.com.gelsdorf.apiacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAcoesApplication {

	public static void main(String[] args)
	{
		System.setProperty("server.port", "80");
		SpringApplication.run(ApiAcoesApplication.class, args);
	}

}
