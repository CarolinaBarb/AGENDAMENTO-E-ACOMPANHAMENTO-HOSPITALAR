package control;

import java.util.Date;

import model.Medico;
import util.Dados;
import util.Validar;

public class ControlMedico {
	
		Validar validar = new Validar();
		
		
		
        public void cadastrar(String nome, String email, String senha, String id, String sexo, 
        		              Date DataNascimento, String crm, String especialidade, String Convenios_aceitos) {
        	Medico medico = new Medico(Convenios_aceitos, especialidade, crm, sexo, id, DataNascimento, email, senha, nome);
        	
        	if(validar.validacrm(crm)) {
        		
        	} else {
        		
        	}
        	medico.setNome(nome);
        	
        	Dados.usuarios.add(medico);
        }
}
