package br.com.seguro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguro.documents.Cliente;
import br.com.seguro.repository.ClienteRepository;
import br.com.seguro.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public List<Cliente> listarClientes() {
		System.out.println("Listando todos os clientes");
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		System.out.println("Pesquisando por ID");
		return this.clienteRepository.findById(id).orElse(null);
		}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		System.out.println("Cadastrando cliente");
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		System.out.println("Atualizando cadastro do cliente");
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void remover(String id) {
		System.out.println("Removendo cadastro");
		this.clienteRepository.deleteById(id);
	}
	}
