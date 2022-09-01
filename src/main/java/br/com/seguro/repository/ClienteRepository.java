package br.com.seguro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.seguro.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
