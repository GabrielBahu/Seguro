package br.com.seguro.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.seguro.documents.Apolice;

@Repository
public interface ApoliceRepository extends MongoRepository<Apolice, String>{

	@Query
	ArrayList<String> listarApolice();

	@Query
	Apolice buscarApolicePorNumero(String numeroApolice);
}
