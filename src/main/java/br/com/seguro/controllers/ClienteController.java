package br.com.seguro.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seguro.documents.Cliente;
import br.com.seguro.responses.Response;
import br.com.seguro.service.ClienteService;

@RestController
@RequestMapping(path = "/seguro/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.ok(this.clienteService.listarClientes());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> ListarPorId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(this.clienteService.listarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
		}
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(name = "id") String id,@RequestBody Cliente cliente) {
		cliente.setId(id);
		return ResponseEntity.ok(this.clienteService.atualizar(cliente));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> remover(@PathVariable(name = "id") String id) {	
		this.clienteService.remover(id);
		return ResponseEntity.ok(1);
	}
}
