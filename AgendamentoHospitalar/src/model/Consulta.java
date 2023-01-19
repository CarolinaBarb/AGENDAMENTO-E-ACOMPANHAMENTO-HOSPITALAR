package model;

import java.util.*;

public class Consulta {
	private String especialidade;
	private String valor;
	private Medico idMedico;
	private String idPaciente;
	private String data;

	// construtores
	public Consulta(String especialidade, String valor, Medico idMedico, String idPaciente) {
		super();
		this.especialidade = especialidade;
		this.valor = valor;
		this.idMedico = idMedico;
		this.idPaciente = idPaciente;
	}

	public Consulta(String especialidade, String valor) {
		super();
		this.especialidade = especialidade;
		this.valor = valor;
	}

	public Consulta() {
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Medico getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
