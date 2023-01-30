package model; 

import java.util.*;


public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String Convenios_aceitos;
    private int idmedico;

    //constructor
    
    


	public Medico(String nome, String email, String senha, String crm) {
		super(nome);
	}





	public Medico(String email, String senha, String crm, String especialidade, String convenios_aceitos,
			int idmedico) {
		super(email, senha);
		this.crm = crm;
		this.especialidade = especialidade;
		Convenios_aceitos = convenios_aceitos;
		this.idmedico = idmedico;
	}





	public Medico(String email, String senha) {
		super(email, senha);
	}





	public Medico() {
		
	}





	public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getConvenios_aceitos() {
        return Convenios_aceitos;
    }

    public void setConvenios_aceitos(String convenios_aceitos) {
        Convenios_aceitos = convenios_aceitos;
    }


	public int getIdmedico() {
		return idmedico;
	}


	public void setIdmedico(int idmedico) {
		this.idmedico = idmedico;
	}





	@Override
	public int tipoUsuario() {
		// medico tipo 1
		return 1;
	}


	public void setMedico(Medico medico) {
		
	}


}