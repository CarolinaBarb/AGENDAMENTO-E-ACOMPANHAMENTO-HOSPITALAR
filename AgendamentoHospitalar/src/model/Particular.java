package model;

import java.util.Scanner;

public class Particular extends Financeiro {
	private String FormaPagamento;

	public Particular(double valor, String tipo, String formaPagamento, String nome) {
		super(valor, tipo);
		FormaPagamento = formaPagamento;
	}

	public String getFormaPagamento() {
		return FormaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		FormaPagamento = formaPagamento;
	}
	
}
