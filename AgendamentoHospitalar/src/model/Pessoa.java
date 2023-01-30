package model;

import java.util.*;

public abstract class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String DataNascimento;

    //constructor
    

	public Pessoa(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}


	public Pessoa(String nome, String email, String senha, String sexo, String dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		DataNascimento = dataNascimento;
	}


	public Pessoa(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
     
	public Pessoa() {
	}


	public Pessoa(String nome2) {
	}



	public abstract int tipoUsuario();

	//Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getDataNascimento() {
        return DataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}