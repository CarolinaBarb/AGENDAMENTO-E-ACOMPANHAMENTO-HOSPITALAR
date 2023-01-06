package model;

import java.util.Date;

public class Medico extends Usuario {
    private String crm;
    private String especialidade;
    private String convenios_aceitos;

    //construtor
    public Medico(String nome, String senha, String id, String sexo, Date DataNascimento, String crm, String especialidade, String convenios_aceitos) {
        super(nome, senha, id, sexo, DataNascimento);
        this.crm = crm;
        this.convenios_aceitos = convenios_aceitos;
        this.especialidade = especialidade;
    }
    //getters and setters


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
        return convenios_aceitos;
    }

    public void setConvenios_aceitos(String convenios_aceitos) {
        this.convenios_aceitos = convenios_aceitos;
    }

    //funcoes
    //esses dois usuarios servem para cadrastro
    //as funcoes podem ser usadas nas classes de agendamento e acompanhamento no view
}