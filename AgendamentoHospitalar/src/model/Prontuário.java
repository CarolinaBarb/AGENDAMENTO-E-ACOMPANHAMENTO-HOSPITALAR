package model;

import java.util.*;

public class Prontuário extends Paciente {
	private String dtconsulta;

	public String getDtconsulta() {
		return dtconsulta;
	}

	public void setDtconsulta(String dtconsulta) {
		this.dtconsulta = dtconsulta;
	}

	public Prontuário(String email, String senha, String dtconsulta) {
		super(email, senha);
		this.dtconsulta = dtconsulta;
	}
	
	
}