package model;

import java.util.Scanner;

public class Receita {
		private String NomePaciente;
		private String MedicoResp;
		private String Medicamento;
		private String DosagemReceitada;
		private String TomarVezes;
		private String Horario;
		private String Dias;
		private String Email;
		private int idreceita;
		
		public Receita(String nomePaciente, String medicoResp, String medicamento, String dosagemReceitada,
				String tomarVezes, String horario, String dias, String email, int idreceita) {
			super();
			NomePaciente = nomePaciente;
			MedicoResp = medicoResp;
			Medicamento = medicamento;
			DosagemReceitada = dosagemReceitada;
			TomarVezes = tomarVezes;
			Horario = horario;
			Dias = dias;
			Email = email;
			this.idreceita = idreceita;
		}
		public Receita() {
			
		}
		public String getNomePaciente() {
			return NomePaciente;
		}
		public void setNomePaciente(String nomePaciente) {
			NomePaciente = nomePaciente;
		}
		public String getMedicamento() {
			return Medicamento;
		}
		public void setMedicamento(String medicamento) {
			Medicamento = medicamento;
		}
		public String getDosagemReceitada() {
			return DosagemReceitada;
		}
		public void setDosagemReceitada(String dosagemReceitada) {
			DosagemReceitada = dosagemReceitada;
		}
		public String getTomarVezes() {
			return TomarVezes;
		}
		public void setTomarVezes(String tomarVezes) {
			TomarVezes = tomarVezes;
		}
		public String getHorario() {
			return Horario;
		}
		public void setHorario(String horario) {
			Horario = horario;
		}
		public String getDias() {
			return Dias;
		}
		public void setDias(String dias) {
			Dias = dias;
		}
		public int getIdreceita() {
			return idreceita;
		}
		public void setIdreceita(int idreceita) {
			this.idreceita = idreceita;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getMedicoResp() {
			return MedicoResp;
		}
		public void setMedicoResp(String medicoResp) {
			MedicoResp = medicoResp;
		}

	}

	
	
	

