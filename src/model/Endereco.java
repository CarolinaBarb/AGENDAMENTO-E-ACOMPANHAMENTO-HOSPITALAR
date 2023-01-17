package model;

public class Endereco {
	private String rua;
	private String cidade;
	private String estado;
	private int numero;
	public Endereco(String rua, String cidade, String estado, int numero) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
