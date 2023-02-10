package model;

import java.util.*;

public class Atestado {
	private String nome;
	private String QtdDias;
	private String justificativa;
	private String Recomendacoes;
	private String validade;
	private int idatestado;

	
	
	public Atestado(String nome, String qtdDias, String justificativa, String recomendacoes, String validade,
			int idatestado) {
		super();
		this.nome = nome;
		QtdDias = qtdDias;
		this.justificativa = justificativa;
		Recomendacoes = recomendacoes;
		this.validade = validade;
		this.idatestado = idatestado;
	}
	
	public Atestado() {
		
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getQtdDias() {
		return QtdDias;
	}



	public void setQtdDias(String qtdDias) {
		QtdDias = qtdDias;
	}



	public String getJustificativa() {
		return justificativa;
	}



	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}



	public String getRecomendacoes() {
		return Recomendacoes;
	}



	public void setRecomendacoes(String recomendacoes) {
		Recomendacoes = recomendacoes;
	}



	public String getValidade() {
		return validade;
	}



	public void setValidade(String validade) {
		this.validade = validade;
	}



	public int getIdatestado() {
		return idatestado;
	}



	public void setIdatestado(int idatestado) {
		this.idatestado = idatestado;
	}
	
	
	

}