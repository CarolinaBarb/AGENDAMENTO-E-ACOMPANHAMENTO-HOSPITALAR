package model;


import java.util.*;

public class Paciente extends Pessoa{
    private String cpf;
    private double altura;
    private double peso;
    private String observacao;
    
    //full constructor
    public Paciente(String nome,String email, String senha, String id, String sexo, Date dataNascimento, String cpf, double altura, double peso,
            String observacao) {
        super(email, senha, sexo, nome, id, dataNascimento);
        this.cpf = cpf;
        this.altura = altura;
        this.peso = peso;
        this.observacao = observacao;
    }
    
    
    public Paciente(String email, String senha) {
		super(email, senha);
	}
   


	public Paciente(String nome, String email, String senha, int i) {
		super(email,senha);
	}


	public Paciente(String email, String senha, String nome) {
		// TODO Auto-generated constructor stub
	}


	//getters and setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
	@Override
	public int tipoUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setPaciente(Paciente paciente) {
		
	}
}