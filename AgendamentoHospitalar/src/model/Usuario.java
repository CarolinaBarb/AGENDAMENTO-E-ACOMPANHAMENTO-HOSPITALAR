package model;

public class Usuario {
	private String email;
	private String senha;
	
	
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public void Usuario1(String email2, String senha2) {
		this.email = email2;
		this.senha = senha2;
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
