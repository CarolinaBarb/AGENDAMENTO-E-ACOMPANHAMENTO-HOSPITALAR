package model;

import java.util.*;

public class Consulta {
	private String especialidade;
	private String valor;
	private String idMedico;
	private String idPaciente;
	private String data;
	private String horario;
	private String data_indisponivel;
	private String email;
	private String diagnostico;
	private String Obs;
	private int ID;
	
	

	



	// construtores

	public Consulta(String especialidade, String valor) {
		super();
		this.especialidade = especialidade;
		this.valor = valor;
	}

	public Consulta(String especialidade, String valor, String idMedico, String idPaciente, String data, String horario,
			String data_indisponivel, String email, String diagnostico, String obs, int iD) {
		super();
		this.especialidade = especialidade;
		this.valor = valor;
		this.idMedico = idMedico;
		this.idPaciente = idPaciente;
		this.data = data;
		this.horario = horario;
		this.data_indisponivel = data_indisponivel;
		this.email = email;
		this.diagnostico = diagnostico;
		Obs = obs;
		ID = iD;
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

	public 	String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
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
	
	public String getData_indisponivel() {
		return data_indisponivel;
	}

	public void setData_indisponivel(String data_indisponivel) {
		this.data_indisponivel = data_indisponivel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getObs() {
		return Obs;
	}

	public void setObs(String obs) {
		Obs = obs;
	}
	



}
