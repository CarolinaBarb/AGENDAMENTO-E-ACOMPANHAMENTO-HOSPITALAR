package model;

public class Dados {
	private Usuario[] usuario = new Usuario[100];
	private int quantidadeUsuario = 1;
	
	public void dados() {
		usuario[1] = new Usuario("fulano@email.com", "11111");
	}

	public Usuario[] getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario[] usuario) {
		this.usuario = usuario;
	}

	public int getQuantidadeUsuario() {
		return quantidadeUsuario;
	}

	public void setQuantidadeUsuario(int quantidadeUsuario) {
		this.quantidadeUsuario = quantidadeUsuario;
	}

	public static void setUsuario(Usuario usuario2) {
	}	

}
