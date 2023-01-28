package model;

import java.util.*;

public class Prontuário extends Paciente {
	private Date dtconsulta;
	private String descricao;
	
	public Prontuário(String nome, String email, String senha, String id, String sexo, String dataNascimento,
			String cpf, String altura2, String peso2, String observacao, int idpaciente, Date dtconsulta,
			String descricao) {
		super(nome, email, senha, id, sexo, dataNascimento, cpf, altura2, peso2, observacao, idpaciente);
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