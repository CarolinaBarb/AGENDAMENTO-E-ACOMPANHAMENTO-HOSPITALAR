package model;

public class Administrador extends Pessoa {
	private int idAdministrador;

	public Administrador(String nome, String email, String senha, String id, String sexo, String dataNascimento2,
			int idAdministrador) {
		super(nome, email, senha, id, sexo, dataNascimento2);
		this.idAdministrador = idAdministrador;
	}
	
	public Administrador () {
		
	}
	
	

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	@Override
	public int tipoUsuario() {

		return 0;
	}

}