package model;

public class Dados {
	private Pessoa[] pessoa = new Pessoa[100];
	private int quantidadepessoa = 1;
	
	public void dados() {
		pessoa[1] = new Pessoa("Fulano", "fulano@email.com", "11111", "01", "masculino", null);
	}

	public Pessoa[] getpessoa() {
		return pessoa;
	}

	public void setpessoa(Pessoa[] pessoa) {
		this.pessoa = pessoa;
	}

	public int getQuantidadepessoa() {
		return quantidadepessoa;
	}

	public void setQuantidadepessoa(int quantidadepessoa) {
		this.quantidadepessoa = quantidadepessoa;
	}

	public static void setpessoa(Pessoa pessoa2) {
	}	

}
