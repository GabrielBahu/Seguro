package br.com.seguro.documents;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Apolice")
public class Apolice {

	private UUID numeroApolice;
	private String dataInicioVigencia;
	private String dataFimVigencia;
	private String placaVeiculo;
	private String valorApolice;
	
	
	public UUID getNumeroApolice() {
		return numeroApolice;
	}
	
	public void setNumeroApolice(UUID numeroApolice) {
		this.numeroApolice = numeroApolice;
	}
	
	public String getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	
	public void setDataInicioVigencia(String dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	
	public String getDataFimVigencia() {
		return dataFimVigencia;
	}
	
	public void setDataFimVigencia(String dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	public String getValorApolice() {
		return valorApolice;
	}
	
	public void setValorApolice(String valorApolice) {
		this.valorApolice = valorApolice;
	}
}
