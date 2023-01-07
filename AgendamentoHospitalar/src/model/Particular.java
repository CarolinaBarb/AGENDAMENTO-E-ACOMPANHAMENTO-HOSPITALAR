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
	
	//funcoes
	public String SelecionarForma() {
		System.out.println("Formas de Pagamento: 1-credito /n 2-debito /n 3-dinheiro");
		Scanner in = new Scanner(System.in);
		FormaPagamento = in.nextLine();
		return FormaPagamento;
	}
	public void GerarRecibo(double valor, String nome) {
		System.out.println("nome: " + nome + "/n"+ "forma de pagamento: " +"/n"+  SelecionarForma()+ "/n" + "valor" + valor);
	}
	
}
