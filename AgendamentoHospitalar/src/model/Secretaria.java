package model;

public class Secretaria extends Pessoa {
	private int idSscretaria;
	private String cpf;
	private String Data_admissao;
	private String funcao;
	private String contato;
	
	
	public Secretaria(String nome, String email, String senha, String id, String sexo, String dataNascimento2,
			int idSscretaria, String cpf, String data_admissao, String funcao, String contato) {
		super(nome, email, senha, id, sexo, dataNascimento2);
		this.idSscretaria = idSscretaria;
		this.cpf = cpf;
		Data_admissao = data_admissao;
		this.funcao = funcao;
		this.contato = contato;
	}
	
	



	public String getCpf() {
		return cpf;
	}





	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	public String getData_admissao() {
		return Data_admissao;
	}





	public void setData_admissao(String data_admissao) {
		Data_admissao = data_admissao;
	}





	public String getFuncao() {
		return funcao;
	}





	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}





	public String getContato() {
		return contato;
	}





	public void setContato(String contato) {
		this.contato = contato;
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
