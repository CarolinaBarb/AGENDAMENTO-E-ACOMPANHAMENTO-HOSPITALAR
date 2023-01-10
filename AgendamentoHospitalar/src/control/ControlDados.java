package control;
import model.*;
import util.Dados;

public class ControlDados {
	private Dados dados =  new Dados();
	
	public ControlDados() {
		dados.dados();
	}

	public Pessoa[] getPessoa() {
		return dados.getpessoa();
	}
	
	public int getQuantidadePessoa() {
		return dados.getQuantidadepessoa();
	}
	
	public void setQuantidadePessoa() {
		dados.setQuantidadepessoa(getQuantidadePessoa());
	}
	
	public void setPessoa() {
		dados.setpessoa(getPessoa());
	}
}
