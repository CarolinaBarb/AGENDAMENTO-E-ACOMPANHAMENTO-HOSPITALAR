package control;

import model.*;

public class ControlUsuario {

	public String criarUsuario(ControlDados dados, String email, String senha) {
		Usuario usuario = new Usuario(email, senha);
		Dados.setUsuario(usuario);
		return null;
	}	
	
	public String logar(ControlDados dados, String email, String senha) {
		Usuario usuario = new Usuario(email, senha);
		Dados.setUsuario(usuario);
		return null;
	}
}
