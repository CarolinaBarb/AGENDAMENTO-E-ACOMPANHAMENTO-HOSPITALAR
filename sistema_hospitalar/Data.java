package model;

import java.util.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;
//construtor
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes= mes;
        this.ano = ano;
    }
//getters and setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    //funcoes
    public String selecionarData(int getDia, int getMes, int getAno){
        String data = getDia +"/"+ getMes + "/" + getAno;

        return data;
    }
}
