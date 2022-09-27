package br.com.seguro.service;

import java.util.List;

import br.com.seguro.documents.Apolice;

public interface ApoliceService {

	List<Apolice> listarApolice();
	
	Apolice listarPorId(String id);
	
	Apolice cadastrar(Apolice apolice);
	
	Apolice atualizar(Apolice apolice);
	
	void remover(String id);
	
}
