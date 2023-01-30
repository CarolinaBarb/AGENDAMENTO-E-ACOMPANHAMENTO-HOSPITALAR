package model;


import java.util.*;

public class Paciente extends Pessoa{
    private String cpf;
    private String altura;  //mudar pra String depois
    private String peso;    //mudar pra String depois
    private String observacao;
    private int idpaciente;
    private String idade;
    
    //full constructor
    
    
    public Paciente(String email, String senha) {
		super(email, senha);
	}
    

	public Paciente(String email, String senha, String cpf, String altura, String peso, String observacao,
			int idpaciente, String idade) {
		super(email, senha);
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
		this.observacao = observacao;
		this.idpaciente = idpaciente;
		this.idade = idade;
	}


	public Paciente() {
		// TODO Auto-generated constructor stub
	}


	//getters and setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    
	public int getIdpaciente() {
		return idpaciente;
	}


	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	@Override
	public int tipoUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}