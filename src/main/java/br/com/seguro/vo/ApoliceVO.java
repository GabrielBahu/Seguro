package br.com.seguro.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.com.seguro.documents.Apolice;

public class ApoliceVO {
	
	String numeroApolice;
	Boolean apoliceVencida;
	int diasVencer;
	String placaVeiculo;
	String valorApolice;
	
	public ApoliceVO(Apolice apolice) {

		int diasVencido = 0;
		this.apoliceVencida = false;

		this.numeroApolice = apolice.getNumeroApolice();

		try {
			diasVencido = this.calculaDatas(this.convertDate(apolice.getDataFimVigencia()));
			this.diasVencer = diasVencido;
		} catch (ParseException e) {
			return;
		}

		if (diasVencido < 0) {
			this.apoliceVencida = true;
		}
		this.placaVeiculo = apolice.getPlacaVeiculo();
		this.valorApolice = apolice.getValorApolice();

	}

	private Date convertDate(String sData) {
		Date date1;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sData);
			System.out.println(sData + "\t" + date1);

			return date1;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private int calculaDatas(Date dataVencimento) throws ParseException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date hoje = formatter.parse(dtf.format(now));

		long diff = dataVencimento.getTime() - hoje.getTime();
//	    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
