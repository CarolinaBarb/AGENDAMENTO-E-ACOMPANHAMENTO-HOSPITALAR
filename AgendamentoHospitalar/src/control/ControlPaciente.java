package control;

import java.util.ArrayList;
import java.util.Date;

import model.Paciente;
import util.Dados;
import util.Validar;

public class ControlPaciente {
	
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	
	public boolean salvar (Paciente m) {
		if(m != null) {
			pacientes.add(m);	
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList <Paciente> retornarTodos(){
		return pacientes;
	}
	
		Validar validar = new Validar();
		

       public void cadastrar(String nome, String email, String senha) {
       	Paciente paciente = new Paciente(email, senha, nome);
        	
             paciente.setNome(nome);
             paciente.setEmail(email);
             paciente.setSenha(senha);
     
       	Dados.paciente.add(paciente);
        
        	
       }
        
       public boolean logar(String email,String senha) {
       	Paciente paciente = new Paciente(email, senha);
       	if(validar.validaemail(email) == true && validar.validasenha(senha)== true) { 
       		return true;
        	}else {
        }
       	paciente.setPaciente(paciente);
       	return Dados.paciente.add(paciente);
       }
}
