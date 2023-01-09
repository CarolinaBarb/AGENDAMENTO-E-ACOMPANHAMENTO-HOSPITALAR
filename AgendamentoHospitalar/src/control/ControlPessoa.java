package control;

import model.*;

public class ControlPessoa {

	public String criarPessoa(ControlDados dados,String nome, String email, String senha) {
		Pessoa pessoa = new Pessoa(nome, senha, email);
		Dados.setpessoa(pessoa);
		return null;
	}	
	
	public String logar(ControlDados dados, String email, String senha) {
		Pessoa pessoa = new Pessoa(email, senha);
		Dados.setpessoa(pessoa);
		return null;
	}
}
