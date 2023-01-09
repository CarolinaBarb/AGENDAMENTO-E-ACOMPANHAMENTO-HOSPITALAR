package model; 

import java.util.*;


public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String Convenios_aceitos;

    //construtor

    public Medico(String nome,String email, String senha, String id, String sexo, Date dataNascimento, String crm, String especialidade,
            String convenios_aceitos) {
        super(nome, email, senha, id, sexo, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.Convenios_aceitos = convenios_aceitos;
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
        return Convenios_aceitos;
    }

    public void setConvenios_aceitos(String convenios_aceitos) {
        Convenios_aceitos = convenios_aceitos;
    }

    //funçao

    public void ObterConvenios() {
        int quantidade = 0;
        System.out.println("digite a quantidade de convenios: ");
        Scanner in = new Scanner(System.in);
        quantidade = in.nextInt();

        for (int i = 0; i <= quantidade; i++) {
            System.out.println("digite o nome do convenio aceito: ");
            Convenios_aceitos = in.nextLine();
            System.out.println(i + Convenios_aceitos);
        }


    }

}