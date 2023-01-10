package model;

public class Exame {
	private String tipo;
	private double valor;
	//construtor
	public Exame(String tipo, double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}
	//getters and setters
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}
