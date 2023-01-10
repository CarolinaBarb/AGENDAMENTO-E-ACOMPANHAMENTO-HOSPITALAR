package model;

public class Medicamento {
	private String nome;
	private double dosagem;
	private String descricao;
	public Medicamento(String nome, double dosagem, String descricao) {
		super();
		this.nome = nome;
		this.dosagem = dosagem;
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getDosagem() {
		return dosagem;
	}
	public void setDosagem(double dosagem) {
		this.dosagem = dosagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
