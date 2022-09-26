package br.com.seguro.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.seguro.documents.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice, String>{

	@Query
	List<Apolice> listarApolice();

}
