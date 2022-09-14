package br.com.seguro.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seguro.documents.Cliente;
import br.com.seguro.repository.ClienteRepository;
import br.com.seguro.utils.Utils;

@RestController
@RequestMapping(value="/seguro")
public class ClienteController {

	ClienteRepository clienteService;
	
	@GetMapping ("/clientes")
	public ResponseEntity<List<Cliente>> listarClientes(){
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente listarPorId(@PathVariable(value="id") String id){
		return clienteService.findById(id).orElse(null);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Cliente cliente) {
		
		String existeCadastro = null;
		
		existeCadastro = ClienteRepository.buscarCPF(ClienteRepository.getCpf());

		if (existeCadastro != null) {
			return new ResponseEntity<>("CPF já cadastrado!", HttpStatus.PRECONDITION_REQUIRED); 
		} else {
			cliente.setNome(cliente.getNome());
			cliente.setCpf(cliente.getCpf());
			cliente.setCidade(cliente.getCidade());
			cliente.setUf(cliente.getUf());

			try {
				if (Utils.isCPF(cliente.getCpf())) {
					Cliente _cliente = clienteService.save(cliente);
					return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("CPF não é válido!", HttpStatus.PRECONDITION_REQUIRED);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	@PutMapping("/clientes/atualizar/{id}")
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void remover(@RequestBody Cliente cliente) {
		clienteService.delete(cliente);
		}
}
