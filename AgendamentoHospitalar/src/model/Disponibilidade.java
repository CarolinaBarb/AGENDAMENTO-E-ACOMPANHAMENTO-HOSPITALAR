package model;

import java.util.*;

public class Disponibilidade {
	private String data;
	private String horario;
	
	
	public Disponibilidade(String data, String horario) {
		this.data = data;
		this.horario = horario;
	}


	public Disponibilidade() {
		
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}

	

	
	

}
