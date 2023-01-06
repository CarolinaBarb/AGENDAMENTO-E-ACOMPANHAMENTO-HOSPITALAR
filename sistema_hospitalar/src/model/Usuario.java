package model;

import java.util.*;

public class Usuario {
    private String nome;
    private String senha;
    private String id;
    private String sexo;
    private Date DataNascimento;



    //construtor
    public Usuario(String nome, String senha, String id, String sexo, Date DataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        this.sexo = sexo;
        this.DataNascimento = DataNascimento;
    }
    //funções
    public void cadastrarUsuario() {
        Scanner in = new Scanner(System.in);
        nome = in.nextLine();

        senha = in.nextLine();

        id = in.nextLine();

        sexo = in.nextLine();

    }
    public void excluirUsuario(){

    }
    public boolean verifLogin(){

        return true;
    }
//getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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