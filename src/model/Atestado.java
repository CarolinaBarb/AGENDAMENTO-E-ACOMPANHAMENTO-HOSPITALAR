package model;

import java.util.*;

public class Atestado {
	private String motivo;
	private Date validade;
	private Date autenticacao;
	

	public Atestado(String motivo, Date validade, Date autenticacao) {
		super();
		this.motivo = motivo;
		this.validade = validade;
		this.autenticacao = autenticacao;
	}
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Date getAutenticacao() {
		return autenticacao;
	}
	public void setAutenticacao(Date autenticacao) {
		this.autenticacao = autenticacao;
	}
	
	

}