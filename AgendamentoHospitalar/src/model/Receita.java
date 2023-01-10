package model;

import java.util.Scanner;

public class Receita {
		private String descricao;
		private String PacienteAtendi;
		private String MedicoResp;
		
		
		public Receita(String descricao, String pacienteAtendi, String medicoResp) {
			super();
			this.descricao = descricao;
			PacienteAtendi = pacienteAtendi;
			MedicoResp = medicoResp;
		}
		
		
		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getPacienteAtendi() {
			return PacienteAtendi;
		}

		public void setPacienteAtendi(String pacienteAtendi) {
			PacienteAtendi = pacienteAtendi;
		}

		public String getMedicoResp() {
			return MedicoResp;
		}


		public void setMedicoResp(String medicoResp) {
			MedicoResp = medicoResp;
		}

	}

	
	
	

