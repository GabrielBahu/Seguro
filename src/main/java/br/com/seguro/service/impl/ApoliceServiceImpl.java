package br.com.seguro.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.seguro.documents.Apolice;
import br.com.seguro.repository.ApoliceRepository;
import br.com.seguro.service.ApoliceService;

public class ApoliceServiceImpl implements ApoliceService {

	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Override
	public List<Apolice> listarApolice() {
		System.out.println("Listando todas Apolices");
		return this.apoliceRepository.findAll();
	}

	@Override
	public Apolice listarPorNumero(UUID numeroApolice) {
		System.out.println("Listando por numero da Apolice");
		return this.apoliceRepository.findOne(numeroApolice);
	}

	@Override
	public Apolice cadastrar(Apolice apolice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apolice atualizar(Apolice apolice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(UUID numeroApolice) {
		// TODO Auto-generated method stub
		
	}

}
