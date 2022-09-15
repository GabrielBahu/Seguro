package br.com.seguro.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "br.com.seguro.controllers" })
@EnableWebMvc
@Repository("br.com.seguro.repository.ClienteRepository")
public class SeguroApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(SeguroApplication.class, args);

	}

}
