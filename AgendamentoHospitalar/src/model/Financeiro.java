package model;

import java.util.Scanner;

public class Financeiro {
	private double valor;
	private String tipo;
	private Paciente Paciente;
	
	public Financeiro(double valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
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
	
	//funcao
	public boolean isConvenio() {
		System.out.println("Selecione o tipo de pagamento: 1- Convenio /n 2- Particular");
		String T;
		Scanner in = new Scanner(System.in);
		T = in.nextLine();
		
		if (getTipo() == T ) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
