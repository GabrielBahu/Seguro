package br.com.seguro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.seguro.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	@Query("SELECT CPF from Cliente CPF where CPF.cpf =:cpf")
	Cliente findByCpf(String cpf);
	
}
