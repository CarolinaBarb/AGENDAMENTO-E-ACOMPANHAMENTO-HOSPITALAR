package control;

import model.*;

public class ControlUsuario {

	public void criarUsuario(String email,String senha) {
		Usuario usuario = new Usuario(email, senha);
		Dados.setUsuario(usuario);
	}	
	
	public void Logar(String email,String senha) {
		Usuario usuario = new Usuario(email, senha);
		Dados.setUsuario(usuario);
	}
}
