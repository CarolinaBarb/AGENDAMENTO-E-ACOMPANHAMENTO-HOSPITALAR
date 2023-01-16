package model;

import java.sql.Date;
import java.util.Scanner;

public class Pagamento {
	private double valor;
	private String tipo;
	private Paciente Paciente;
	private Date dataPagamento;
	
	public Pagamento(double valor, String tipo, Date dataPagamento, Paciente Paciente) {
		this.valor = valor;
		this.tipo = tipo;
		this.dataPagamento = dataPagamento;
		this.Paciente = Paciente;
		
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	

	

}
