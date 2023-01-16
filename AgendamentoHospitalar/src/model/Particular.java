package model;

import java.sql.Date;
import java.util.Scanner;

public class Particular extends Pagamento {
	private String FormaPagamento;
	
	
	public Particular(double valor, String tipo, Date dataPagamento, model.Paciente Paciente, String formaPagamento) {
		super(valor, tipo, dataPagamento, Paciente);
		FormaPagamento = formaPagamento;
	}

	public String getFormaPagamento() {
		return FormaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		FormaPagamento = formaPagamento;
	}
	
}
