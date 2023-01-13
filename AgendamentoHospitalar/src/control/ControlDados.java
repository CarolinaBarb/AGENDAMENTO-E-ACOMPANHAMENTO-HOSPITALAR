package control;
import java.util.ArrayList;

import model.*;
import util.Dados;

public class ControlDados {
	
	
	private Dados d =  new Dados();
	
	public ControlDados() {
		d.fillWithSomeData();
	}

	public Pessoa[] getPessoa() {
		return d.getpessoa();
	}
		
	public void setPessoa() {
		d.setpessoa(getPessoa());
	}
}
