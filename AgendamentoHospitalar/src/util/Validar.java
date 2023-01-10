package util;

public class Validar {
	
	public boolean validaCPF(String CPF) {
		if(CPF.length() < 11)
			return true;
		return false;
	}
	

}
