package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.ControlDados;
import model.Paciente;

public class Validar {
		
	public boolean validacrm(String crm) {
		if(crm.length() == 11)
			return true;
		else
		return false;
	}	
	
	/**public boolean validaemail(String email) {
		boolean emailvalid = false;
		if(email != null && email.length()>0) {
			String expression = "^[\\\\w\\\\.-]+@([\\\\w\\\\-]+\\\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if(matcher.matches()) {
	        	emailvalid = true;
	        }	     
		}
			return emailvalid;
	}
	
	public boolean validasenha(String senha) {
		boolean senhavalid = false;
		if(senha != null && senha.length()>0) {
			String expression = "[0-9a-zA-Z$*&_/@#]{4,}";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(senha);
	        if(matcher.matches()) {
	        	senhavalid = true;
	        }	     
		}
			return senhavalid;
	}*/
	
	public boolean validacriarConta(ControlDados d, String nome, String email, String senha) {
		boolean cadastrovalid = false;
		int qtPaciente = d.getQtPaciente();
		if(senha.matches("[0-9a-zA-Z$*&_/@#]{4,}") || email.matches("^(.+)@(.+)$")
				|| nome.matches("[0-9a-zA-Z]+")) {
			return cadastrovalid = true;
		}
		d.setPaciente();
		d.setQtPaciente(qtPaciente + 1);
		return cadastrovalid;
	}
	
	
	public boolean validaLoginPacient(ControlDados d, String email, String senha) {
		boolean loginvalidP = false;
		String senhaP = "";
		for(int i = 0; i < d.getQtPaciente(); i++ ) {
			if(d.getPaciente()[i].getEmail().equals(email)) {
				loginvalidP = true;
			}
		}
		for(int i = 0; i < d.getQtPaciente(); i++) {
			if(d.getPaciente()[i].getEmail().equals(email)) {
				senhaP = d.getPaciente()[i].getSenha();
			}
		}
		return loginvalidP;
	}
	
	public boolean validaLoginMedic(ControlDados d, String email, String senha) {
		boolean loginvalidM = false;
		String senhaM = ""; 
		for(int i = 0; i < d.getQtMedico(); i++ ) {
			if(d.getMedico()[i].getEmail().equals(email)) {
				loginvalidM = true;
			}
		}
		for(int i = 0; i < d.getQtMedico(); i++) {
			if(d.getMedico()[i].getEmail().equals(email)) {
				senhaM = d.getMedico()[i].getSenha();
			}
		}
		return loginvalidM;
	}
		
	
}
