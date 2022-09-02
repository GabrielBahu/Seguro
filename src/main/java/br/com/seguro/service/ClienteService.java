package br.com.seguro.service;

import java.util.List;

import br.com.seguro.documents.Cliente;

public interface ClienteService {

    List<Cliente> listarClientes();
    
    Cliente listarPorId(String id);
    
    Cliente cadastrar(Cliente cliente);
    
    Cliente atualizar(Cliente cliente);
    
	void remover(String id);
   
    
}
