package control;

import model.Medico;
import util.Dados;
import util.Validar;

public class ControlMedico {
	
		Validar validar = new Validar();
		
        public void cadastrar(String nome, String email, String CPF) {
        	Medico medico = new Medico();
        	
        	if(validar.validaCPF(CPF)) {
        		
        	} else {
        		
        	}
        	medico.setNome(nome);
        	
        	Dados.usuarios.add(medico);
        }
}
