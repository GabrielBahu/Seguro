package br.com.seguro.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seguro.documents.Cliente;
import br.com.seguro.service.ClienteService;

@RestController
@RequestMapping(path = "/seguro/clientes")
public class ClienteController {

	private ClienteService clienteservice;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(this.clienteservice.listarClientes());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> ListarPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(this.clienteservice.listarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		
	}
}
