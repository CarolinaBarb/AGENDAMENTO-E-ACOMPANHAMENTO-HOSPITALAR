package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
		
	public boolean validacrm(String crm) {
		if(crm.length() == 11)
			return true;
		else
		return false;
	}	
	
	public boolean validaemail(String email) {
		boolean emailvalid = false;
		if(email != null && email.length()>0) {
			String expression = "^[\\\\w\\\\.-]+@([\\\\w\\\\-]+\\\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if(matcher.matches()) {
	        	emailvalid = true;
	        }	     
		}
			return emailvalid;
	}
	
	public boolean validasenha(String senha) {
		boolean senhavalid = false;
		if(senha != null && senha.length()>0) {
			String expression = "[0-9a-zA-Z$*&_/@#]{4,}";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(senha);
	        if(matcher.matches()) {
	        	senhavalid = true;
	        }	     
		}
			return senhavalid;
	}
	
}
