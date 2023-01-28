package model;

public class Administrador extends Pessoa {
	private int idAdministrador;
	private String cpf;
	
	
	public Administrador(String nome, String email, String senha, String id, String sexo, String dataNascimento2,
			int idAdministrador, String cpf) {
		super(nome, email, senha, id, sexo, dataNascimento2);
		this.idAdministrador = idAdministrador;
		this.cpf = cpf;
	}



	public Administrador () {
		
	}
	
	

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	

	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public int tipoUsuario() {

		return 0;
	}

}