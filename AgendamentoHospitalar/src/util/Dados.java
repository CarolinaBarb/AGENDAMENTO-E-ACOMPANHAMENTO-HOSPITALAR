package util;

import model.*;

import java.util.*;

public class Dados {
	public static final ArrayList<Paciente> paciente = new ArrayList<Paciente>();
	public static final ArrayList<Medico> medico = new ArrayList<Medico>();
	private  Medico[] medicos = new Medico[50];
	private Paciente [] pacientes = new Paciente[50];
	private Consulta[] consultas = new Consulta[50];
	private Financeiro[] finan = new Financeiro[50];
	private Endereco[] enderecos = new Endereco[50];
	
	
	public void fillWithSomeData() {
		Date d = Calendar.getInstance().getTime();
		for(int i = 0; i < 5; i++) {
			medicos[i] = new Medico("Fulano", "fulano@email.com", "123123", "CRM/SP 123456.");
			pacientes[i] = new Paciente("Ana", "ana@gmail.com", "1234");
			consultas[i] = new Consulta("dermatologista", 150.00);
			finan[i] = new Financeiro(100.00, "exame");
			enderecos[i] = new Endereco("02", "Brsilia", "DF", 57);			
		}
	}
	
	public Paciente[] getPacientes() {
		return pacientes;
	}
	
	public void setPacientes(Paciente[] pacientes) {
		this.pacientes = pacientes;
	}

	public Medico[] getMedicos() {
		return medicos;
	}

	public void setMedicos(Medico[] medicos) {
		this.medicos = medicos;
	}

	public Consulta[] getConsultas() {
		return consultas;
	}

	public void setConsultas(Consulta[] consultas) {
		this.consultas = consultas;
	}

	public Financeiro[] getFinan() {
		return finan;
	}

	public void setFinan(Financeiro[] finan) {
		this.finan = finan;
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}
}
	
	
	

