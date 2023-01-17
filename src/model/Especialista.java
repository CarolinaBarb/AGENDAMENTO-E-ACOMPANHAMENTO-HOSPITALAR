package model;

import java.util.Date;

public class Especialista extends Pessoa{
	private String funcao;

	public Especialista(String nome, String email, String senha, String id, String sexo, Date dataNascimento,
			String funcao) {
		super(nome, email, senha, id, sexo, dataNascimento);
		this.funcao = funcao;
	}
	

	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	@Override
	public int tipoUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
