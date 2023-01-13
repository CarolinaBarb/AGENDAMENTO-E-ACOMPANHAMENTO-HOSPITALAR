package control;
import java.util.ArrayList;

import model.*;
import util.Dados;

public class ControlDados {
	
	
	private Dados d =  new Dados();
	
	public ControlDados() {
		d.dados();
	}

	public Pessoa[] getPessoa() {
		return d.getpessoa();
	}
	
	public int getQuantidadePessoa() {
		return d.getQuantidadepessoa();
	}
	
	public void setQuantidadePessoa() {
		d.setQuantidadepessoa(getQuantidadePessoa());
	}
	
	public void setPessoa() {
		d.setpessoa(getPessoa());
	}
}
