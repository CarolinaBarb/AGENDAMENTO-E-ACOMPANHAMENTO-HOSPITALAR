package model; 

import java.util.*;


public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String Convenios_aceitos;

    //constructor

    public Medico(String nome,String email, String senha, String id, String sexo, Date dataNascimento, String crm, String especialidade,
            String convenios_aceitos) {
        super(nome, email, senha, id, sexo, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.Convenios_aceitos = convenios_aceitos;
    }


    


	public Medico(String email, String senha) {
		super(email, senha);
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


	@Override
	public int tipoUsuario() {
		// medico tipo 1
		return 1;
	}


	public void setMedico(Medico medico) {
		
	}


}