package model;
import java.util.Date;
import java.util.Scanner.*;

public class Contato {
	private String nome;
	private  int id;
	private String sexo;
	private Date dtnascimento;
	
	
	
	public Contato(String nome,int id, String sexo, Date dtnascimento) {
		this.nome = nome;
		this.id = id;
		this.sexo = sexo;
		this.dtnascimento = dtnascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	
}
