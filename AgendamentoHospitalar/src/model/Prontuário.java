package model;

import java.util.*;

public class Prontuário extends Paciente {
	private Date dtconsulta;
	private String descricao;
	
	public Prontuário(String email, String senha, Date dtconsulta, String descricao) {
		super(email, senha);
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