package model;

import java.util.Scanner;

public class Data {
	protected String dia;
	protected String mes;
	protected String ano;
	protected int hora;
	protected int minuto;
	protected int segundos;
	
	//construtor
	public Data(String dia, String mes, String ano, int hora, int minuto, int segundos) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;
		this.segundos = segundos;
	}
	
	//getters and setters
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	 //funcoes
	public String ObterHora(int hora, int minuto, int segundos) {
		return hora + ":" + minuto + ":" + segundos;
	}

	public String ObterData(String dia, String mes, String ano) {
		return dia + "/" + mes + "/" + ano;
	}
	
	public void SelecionarDisp() {
			int diasDisp = 0;
			Scanner in = new Scanner(System.in);
			System.out.println("Selecione quantos dias estão disponiveis: ");
			diasDisp = in.nextInt();
			
			for (int i = 0; i <= diasDisp; i++) {
				System.out.println("Selecione a dia disponível: ");
				dia = in.next();
				mes = in.next();
				ano = in.next();
				
				ObterData(dia, mes, ano);
				System.out.println("Selecionar Horários");
				hora= in.nextInt();
				minuto = in.nextInt();
				segundos = in.nextInt();
				
				ObterHora(hora, minuto, segundos);	
	}
}
}
