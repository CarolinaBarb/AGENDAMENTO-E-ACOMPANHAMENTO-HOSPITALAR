package control;
import java.util.ArrayList;

import model.*;
import util.Dados;

public class ControlDados {
	
	
	private Dados d =  new Dados();
	
	public ControlDados() {
		d.fillWithSomeData();
	}

	public Paciente[] getPaciente() {
		return d.getPacientes();
	}
	
	public void setPaciente() {
		d.setPacientes(getPaciente());
	}
	
	
	public int getQtPaciente() {
		return d.getQtPaciente();
	}
	
	public void setQtPaciente(int val) {
		d.setQtPaciente(val);
	}
	
	public Medico[] getMedico() {
		return d.getMedicos();
	}
	
	public void setMedico() {
		d.setMedicos(getMedico());
	}
	
	public int getQtMedico() {
		return d.getQtPaciente();
	}
	
	public void setQtMedico(int val) {
		d.setQtPaciente(val);
	}
}
