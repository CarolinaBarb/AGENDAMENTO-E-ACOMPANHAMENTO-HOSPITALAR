package control;
import model.*;

public class ControlDados {
	private Dados dados =  new Dados();
	
	public ControlDados() {
		dados.dados();
	}

	public Usuario[] getUsuario() {
		return dados.getUsuario();
	}
	
	public int getQuantidadeUsuario() {
		return dados.getQuantidadeUsuario();
	}
	
	public void setQuantidadeUsuario() {
		dados.setQuantidadeUsuario(getQuantidadeUsuario());
	}
	
	public void setUsuario() {
		dados.setUsuario(getUsuario());
	}
}
