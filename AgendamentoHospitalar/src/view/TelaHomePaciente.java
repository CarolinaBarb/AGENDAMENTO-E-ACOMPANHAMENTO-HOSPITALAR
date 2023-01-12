package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaHomePaciente implements ActionListener {
	JFrame container;
	private JButton marcarconsulta;
	private JButton agendamento;
	private JButton pagamentos;
	private JButton documentos;
	private JToolBar toolBar;
	private JLabel markClinic;
	private JComboBox<String> comboBox;
	private JMenuItem logout, verReceitas, verAtestados, verEncaminhamentos;
	
	public TelaHomePaciente(){
		
		container = new JFrame("Home");
		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("HomePaciente");
		container.setSize(1066, 639);
		container.setLocation(700, 700);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		marcarconsulta = new JButton("Marcar Consultas");
		marcarconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		marcarconsulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		marcarconsulta.setBackground(new Color(245, 255, 250));
		marcarconsulta.setBounds(36, 215, 216, 213);
		
		agendamento = new JButton("Agendamentos");
		agendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		agendamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamento.setBackground(new Color(245, 255, 250));
		agendamento.setBounds(287, 215, 216, 213);

		pagamentos = new JButton("Pagamentos");
		pagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pagamentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pagamentos.setBackground(new Color(245, 255, 250));
		pagamentos.setBounds(540, 215, 216, 213);
		
		documentos = new JButton("Documentos");
		documentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		documentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		documentos.setBackground(new Color(245, 255, 250));
		documentos.setBounds(792, 215, 216, 213);
		
		toolBar = new JToolBar();
		toolBar.setToolTipText("");
		toolBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.setBackground(new Color(240, 230, 140));
		toolBar.setBounds(0, 0, 1052, 21);
		
		markClinic = new JLabel("Mark Clinic");
		markClinic.setForeground(new Color(148, 0, 211));
		markClinic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toolBar.add(markClinic);
		
        String[] items = {"Receitas", "Atestados", "Encaminhamentos", "Sair"};
		
		comboBox = new JComboBox<>(items);
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setBounds(941, 0, 101, 21);
		container.getContentPane().add(comboBox);
		
	      
		verReceitas = new JMenuItem("Receitas");
		verReceitas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox.add(verReceitas);
		
		verAtestados = new JMenuItem("Atestados");
		verAtestados.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox.add(verAtestados);
		
		verEncaminhamentos = new JMenuItem("Encaminhamentos");
		verEncaminhamentos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox.add(verEncaminhamentos);
		
		logout = new JMenuItem("Sair");
		logout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox.add(logout);

		
		verReceitas = new JMenuItem("Receitas");
		verReceitas.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		
		verAtestados = new JMenuItem("Atestados");
		verAtestados.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		verEncaminhamentos = new JMenuItem("Encaminhamentos");
		verEncaminhamentos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		logout = new JMenuItem("Sair");
		logout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		container.getContentPane().add(marcarconsulta);
		container.getContentPane().add(agendamento);
		container.getContentPane().add(pagamentos);
		container.getContentPane().add(documentos);
		container.getContentPane().add(toolBar);
		
		
		
		container.setVisible(true);
		
		marcarconsulta.addActionListener(this);
		agendamento.addActionListener(this);
		pagamentos.addActionListener(this);
		documentos.addActionListener(this);

	}


	void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}



	public static void main(String[] args) {
		new TelaHomePaciente();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
