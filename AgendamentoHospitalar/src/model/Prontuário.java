package model;

import java.util.*;

public class Prontuário extends Paciente {
	private Date dtconsulta;
	private String descricao;
	
	
	public Prontuário(String nome, String email, String senha, String id, String sexo, String dataNascimento, String cpf,
			double altura, double peso, String observacao, Date dtconsulta, String descricao) {
		super(nome, email, senha, id, sexo, dataNascimento, cpf, altura, peso, observacao);
		this.dtconsulta = dtconsulta;
		this.descricao = descricao;
	}
	
	public Date getDtconsulta() {
		return dtconsulta;
	}
	public void setDtconsulta(Date dtconsulta) {
		this.dtconsulta = dtconsulta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}