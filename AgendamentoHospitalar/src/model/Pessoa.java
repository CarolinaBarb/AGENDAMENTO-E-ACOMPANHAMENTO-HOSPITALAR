package model;

import java.util.*;

public class Pessoa {
	private String nome;
	private String id;
	private String sexo;
	private Date DataNascimento;
	
	//construtor
	public Pessoa(String nome, String id, String sexo, Date dataNascimento) {
		this.nome = nome;
		this.id = id;
		this.sexo = sexo;
		this.DataNascimento  = dataNascimento;
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
}
