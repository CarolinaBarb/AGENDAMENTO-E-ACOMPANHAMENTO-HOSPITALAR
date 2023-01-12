package control;

import model.Medico;

import java.util.*;
import java.util.Date;

import model.Medico;
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
		
		
		
        public void cadastrar(String nome, String email, String senha, String id, String sexo, 
        		              Date DataNascimento, String crm, String especialidade, String Convenios_aceitos) {
        	Medico medico = new Medico(Convenios_aceitos, especialidade, crm, sexo, id, DataNascimento, email, senha, nome);
        	
        	if(validar.validacrm(crm)) {
        		
        	} else {
        		
        	}
        	medico.setNome(nome);
            medico.setCrm(crm);
            medico.setDataNascimento(DataNascimento);
            medico.setEmail(email);
            medico.setId(id);
            medico.setEspecialidade(especialidade);
            medico.setSenha(senha);
            medico.setSexo(sexo);
            medico.setConvenios_aceitos(Convenios_aceitos);
            
        	Dados.usuarios.add(medico);
        }
        
        public boolean logar(String email,String senha) {
        	Medico medico = new Medico(email, senha);
        	if(validar.validaemail(email) == true && validar.validasenha(senha)== true) {
        		return true;
        	}else {
        	}
        	medico.setMedico(medico);
        	return Dados.usuarios.add(medico);
        }
}
