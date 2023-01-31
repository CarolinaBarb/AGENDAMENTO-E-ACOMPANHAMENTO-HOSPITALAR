package model;

public class Funcionario extends Pessoa {
	private int idfuncionario;
	private String cpf;
	private String Data_admissao;
	private String funcao;
	private String contato;
	
	
	
	
	



	public Funcionario(String email, String senha, int idfuncionario, String cpf, String data_admissao, String funcao,
			String contato) {
		super(email, senha);
		this.idfuncionario = idfuncionario;
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





	public Funcionario() {
		
	}



	public int getIdfuncionario() {
		return idfuncionario;
	}



	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}



	@Override
	public int tipoUsuario() {

		return 0;
	}
	
	

}
