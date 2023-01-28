package model;

public class Secretaria extends Pessoa {
	private int idSscretaria;
	
	

	public Secretaria(String nome, String email, String senha, String id, String sexo, String dataNascimento2,
			int idSscretaria) {
		super(nome, email, senha, id, sexo, dataNascimento2);
		this.idSscretaria = idSscretaria;
	}
	public Secretaria() {
		
	}



	public int getIdSscretaria() {
		return idSscretaria;
	}



	public void setIdSscretaria(int idSscretaria) {
		this.idSscretaria = idSscretaria;
	}



	@Override
	public int tipoUsuario() {

		return 0;
	}
	
	

}
