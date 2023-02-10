package model;

import java.util.*;

public class Atestado {
	private String motivo;
	private String validade;
	private int idatestado;

	
	public Atestado(String motivo, String validade, int idatestado) {
		super();
		this.motivo = motivo;
		this.validade = validade;
		this.idatestado = idatestado;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
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