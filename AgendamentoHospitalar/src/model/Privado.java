package model;

public class Privado extends Pagamento {
	private String tipo;
	private String parcelas;
	

	
	public Privado(int idpagamento, String nome, String dataPagamento, String valor) {
		super(idpagamento, nome, dataPagamento, valor);
	}



	public Privado(int idpagamento, String nome, String dataPagamento, String valor, String tipo, String parcelas) {
		super(idpagamento, nome, dataPagamento, valor);
		this.tipo = tipo;
		this.parcelas = parcelas;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
