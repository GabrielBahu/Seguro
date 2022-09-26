package br.com.seguro.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.seguro.documents.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	@Query
	ArrayList<String> listarClientes();
	
	@Query
	Cliente listarPorId(String id);
	
//	@Query("Select CPF from Cliente CPF where CPF.cpf =:cpf")
//	
//	 static String buscarCPF(String cpf) {
//
//		return cpf;
//	}
//
//	public  static String getCpf() {
//		
//		Cliente cliente = new Cliente();
//		
//		cliente.getCpf();
//		
//		return cliente.getCpf();
//		
//	}

	

	
}
