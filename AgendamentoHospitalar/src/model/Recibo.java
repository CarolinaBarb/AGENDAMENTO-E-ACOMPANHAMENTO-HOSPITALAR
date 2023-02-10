package model;

public class Recibo {
	private String nome;
	private String ValorTotal;
	private String data;
	private String Descricao;
	private String Email_Paciente;

	
	public Recibo(String nome, String valorTotal, String data, String descricao, String email_Paciente) {
		super();
		this.nome = nome;
		ValorTotal = valorTotal;
		this.data = data;
		Descricao = descricao;
		Email_Paciente = email_Paciente;
	}
	public Recibo() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(String valorTotal) {
		ValorTotal = valorTotal;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public String getEmail_Paciente() {
		return Email_Paciente;
	}
	public void setEmail_Paciente(String email_Paciente) {
		Email_Paciente = email_Paciente;
	}

}
