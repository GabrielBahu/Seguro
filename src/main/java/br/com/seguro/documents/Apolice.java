package br.com.seguro.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Apolice")
public class Apolice {

	private String id;
	private String numeroApolice;
	private String dataInicioVigencia;
	private String dataFimVigencia;
	private String placaVeiculo;
	private String valorApolice;
	
	
	public String getNumeroApolice() {
		return numeroApolice;
	}
	
	public void setNumeroApolice(String numeroApolice) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
