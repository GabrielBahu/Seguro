package br.com.seguro.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

import br.com.seguro.documents.Apolice;
import br.com.seguro.repository.ApoliceRepository;
import br.com.seguro.utils.Utils;
import br.com.seguro.vo.ApoliceVO;

@RestController
@RequestMapping(value="/seguro")
public class ApoliceController {

	private ApoliceRepository apoliceRepository;
	
	@GetMapping ("/apolices")
	public ResponseEntity<List<Apolice>> listarTodasApolices() {
		try {
			List<Apolice> apo = new ArrayList<Apolice>();

			apoliceRepository.findAll().forEach(apo::add);

			if (apo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(apo, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/apolices/{id}")
	public ResponseEntity<ApoliceVO> buscarApolicePorNumero(@PathVariable("id") String numeroApolice) {
	Apolice apolice = apoliceRepository.buscarApolicePorNumero(numeroApolice);

	ApoliceVO apoVO = new ApoliceVO(apolice);
	if (apolice != null) {
		return new ResponseEntity<>(apoVO, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@PostMapping("/cadastrarApolice")
	public ResponseEntity<Apolice> cadastrar(@RequestBody Apolice apolice) {
	
		ArrayList<String> listaApolice = apoliceRepository.listarApolice();
		
		Apolice apoNovo = new Apolice();
		
		apolice.setNumeroApolice(Utils.randomNovo(listaApolice));
		apolice.setDataInicioVigencia(apolice.getDataInicioVigencia());
		apolice.setDataFimVigencia(apolice.getDataFimVigencia());
		apolice.setPlacaVeiculo(apolice.getPlacaVeiculo());
		apolice.setValorApolice(apolice.getValorApolice());
		
		try {
			Apolice _apolice = apoliceRepository.save(apoNovo);
			return new ResponseEntity<>(_apolice, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/apolices/atualizar/{id}")
	public ResponseEntity<Apolice> atualizarApolice(@PathVariable("id") String id, @RequestBody Apolice apolice) {
		Optional<Apolice> apoliceBanco = apoliceRepository.findById(id);

		if (apoliceBanco.isPresent()) {
			Apolice _apolice = apoliceBanco.get();

			if (!" ".equals(apolice.getNumeroApolice())) {
				_apolice.setNumeroApolice(apolice.getNumeroApolice());
			}
			_apolice.setPlacaVeiculo(apolice.getPlacaVeiculo());
			_apolice.setValorApolice(apolice.getValorApolice());
			_apolice.setDataInicioVigencia(apolice.getDataInicioVigencia());
			_apolice.setDataFimVigencia(apolice.getDataFimVigencia());

			return new ResponseEntity<>(apoliceRepository.save(_apolice), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletarApolice/{id}")
	public ResponseEntity<HttpStatus> deletarApolice(@PathVariable("id") String id) {
		try {
			apoliceRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
