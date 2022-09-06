package br.com.seguro.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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
import br.com.seguro.repository.ClienteRepository;
import br.com.seguro.responses.Response;

@RestController
@RequestMapping(path = "/seguro/clientes")
public class ClienteController {

	private ClienteRepository clienteService;
	
	Cliente clt = new Cliente();
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		try {
			List<Cliente> clt2 = new ArrayList<Cliente>();
			
			clienteService.findAll().forEach(clt2::add);
			
			if(clt2.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(clt2, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> ListarPorId(@PathVariable("id") String id){
		Optional<Cliente> cliente = clienteService.findById(id);
		
		if (cliente.isPresent()) {
			return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/novo")
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente request){
		return ResponseEntity.ok(clienteService.save(request));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Cliente>> atualizar(@PathVariable(name = "id") String id,@Valid @RequestBody Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
		}		
		cliente.setId(id);
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.save(cliente)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {	
		this.clienteService.deleteById(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}
