package model;

import java.util.Date;

public class Paciente extends Usuario {
    private String cpf;
    private String observacao;
    private String convenio;

    // construtor
    public Paciente(String nome, String senha, String id, String sexo, Date DataNascimento, String cpf, String observacao, String convenio) {
        super(nome, senha, id, sexo, DataNascimento);
        this.cpf = cpf;
        this.convenio = convenio;
        this.observacao = observacao;
    }
    //getters and setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //funcoes
    // funcao de agendar consulta n exite, tem que fazer uma classe para agendar
    // e outra para acompanhar
}
