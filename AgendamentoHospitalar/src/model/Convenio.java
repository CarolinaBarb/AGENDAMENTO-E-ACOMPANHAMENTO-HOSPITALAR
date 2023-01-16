package model;

import java.sql.Date;
import java.util.Scanner;

public class Convenio extends Pagamento {
	private String nome;
	private String associados;
	private String codigo;
	
	

	public Convenio(double valor, String tipo, Date dataPagamento, model.Paciente Paciente, String nome,
			String associados, String codigo) {
		super(valor, tipo, dataPagamento, Paciente);
		this.nome = nome;
		this.associados = associados;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAssociados() {
		return associados;
	}

	public void setAssociados(String associados) {
		this.associados = associados;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
