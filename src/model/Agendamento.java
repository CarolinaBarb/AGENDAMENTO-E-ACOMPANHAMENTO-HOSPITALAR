package model;

import java.util.*;

public class Agendamento {
	private Medico idMedico;
	private Paciente idPaciente;
	private Exame exame;
	private Consulta consulta;
	
	//contructores
	public Agendamento(Medico idMedico, Paciente idPaciente, Exame exame, Consulta consulta) {
		super();
		this.idMedico = idMedico;
		this.idPaciente = idPaciente;
		this.exame = exame;
		this.consulta = consulta;
	}
	
	//getters and setters
	public Medico getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Medico idMedico) {
		this.idMedico = idMedico;
	}
	public Paciente getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	

}
