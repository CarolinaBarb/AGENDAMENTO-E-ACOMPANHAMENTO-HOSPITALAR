package control;

import model.Medico;

import java.util.*;
import java.util.Date;

import util.Dados;
import util.Validar;

public class ControlMedico {
	
	private ArrayList<Medico> medicos = new ArrayList<>();
	
	public boolean salvar (Medico m) {
		if(m != null) {
			medicos.add(m);	
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList <Medico> retornarTodos(){
		return medicos;
	}
	
	
	
	
		Validar validar = new Validar();
		
		
		
        public void cadastrar(String nome, String email, String senha, String crm) {
        	Medico medico = new Medico(crm, email, senha, nome);
        	
        	if(validar.validacrm(crm)) {
        		
        	} else {
        		
        	}
        	medico.setNome(nome);
            medico.setCrm(crm);
            medico.setEmail(email);
            medico.setSenha(senha);
            
        	Dados.medico.add(medico);
        }
        
        public boolean logar(String email,String senha) {
        	Medico medico = new Medico(email, senha);
        	if(validar.validaemail(email) == true && validar.validasenha(senha)== true) {
        		return true;
        	}else {
        	}
        	medico.setMedico(medico);
        	return Dados.medico.add(medico);
        }
}
