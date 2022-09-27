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
	public Apolice listarPorId(String id) {
		System.out.println("Listando por numero da Apolice");
		return this.apoliceRepository.findById(id).orElse(null);
	}

	@Override
	public Apolice cadastrar(Apolice apolice) {
		System.out.println("Cadastrando Apolice");
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public Apolice atualizar(Apolice apolice) {
		System.out.println("Atualizando dados Apolice");
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public void remover(String id) {
		System.out.println("Removendo Apolice");
		this.apoliceRepository.deleteById(id);
		
	}

}
