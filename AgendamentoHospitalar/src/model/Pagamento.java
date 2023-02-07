package model;

import java.sql.Date;
import java.util.Scanner;

public class Pagamento {
	private int idpagamento;
	private String Nome;
	private String DataPagamento;
	private String valor;
	
	public Pagamento(int idpagamento, String nome, String dataPagamento, String valor) {
		super();
		this.idpagamento = idpagamento;
		Nome = nome;
		DataPagamento = dataPagamento;
		this.valor = valor;
	}
	
	public int getIdpagamento() {
		return idpagamento;
	}
	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
