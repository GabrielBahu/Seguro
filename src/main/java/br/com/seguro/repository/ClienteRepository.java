package br.com.seguro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.seguro.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	@Query("Select CPF from Cliente CPF where CPF.cpf =:cpf")
	
	 static String buscarCPF(String cpf) {

		return cpf;
	}

	public  static String getCpf() {
		
		Cliente cliente = new Cliente();
		
		cliente.getCpf();
		
		return cliente.getCpf();
		
	}

	

	
}
