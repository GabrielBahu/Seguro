package br.com.seguro.service;

import java.util.List;
import java.util.UUID;

import br.com.seguro.documents.Apolice;

public interface ApoliceService {

	List<Apolice> listarApolice();
	
	Apolice listarPorNumero(UUID numeroApolice);
	
	Apolice cadastrar(Apolice apolice);
	
	Apolice atualizar(Apolice apolice);
	
	void remover(UUID numeroApolice);
	
}
