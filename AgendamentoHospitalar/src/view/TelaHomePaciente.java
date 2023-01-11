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
	private JPopupMenu popupMenu;
	private JMenuItem logout, verReceitas, verAtestados, verEncaminhamentos;
	
	public TelaHomePaciente(){
		
		container = new JFrame("Home");
		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("HomePaciente");
		container.setSize(1132, 820);
		container.setLocation(700, 700);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		marcarconsulta = new JButton("Marcar Consulta");
		marcarconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		marcarconsulta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		marcarconsulta.setBackground(new Color(152, 251, 152));
		marcarconsulta.setBounds(68, 316, 216, 213);
		
		agendamento = new JButton("Agendamentos");
		agendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		agendamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamento.setBackground(new Color(152, 251, 152));
		agendamento.setBounds(328, 316, 216, 213);

		pagamentos = new JButton("Pagamentos");
		pagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pagamentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pagamentos.setBackground(new Color(152, 251, 152));
		pagamentos.setBounds(574, 316, 216, 213);
		
		documentos = new JButton("Documentos");
		documentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		documentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		documentos.setBackground(new Color(152, 251, 152));
		documentos.setBounds(834, 316, 216, 213);
		
		toolBar = new JToolBar();
		toolBar.setToolTipText("");
		toolBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.setBackground(new Color(152, 251, 152));
		toolBar.setBounds(-13, 0, 1131, 69);
		
		markClinic = new JLabel("Mark Clinic");
		markClinic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(markClinic);

		popupMenu = new JPopupMenu();
		popupMenu.setBackground(new Color(255, 192, 203));
		
		toolBar.add(popupMenu);
		
		verReceitas = new JMenuItem("Receitas");
		popupMenu.add(verReceitas);
		
		verAtestados = new JMenuItem("Atestados");
		popupMenu.add(verAtestados);
		
		verEncaminhamentos = new JMenuItem("Encaminhamentos");
		popupMenu.add(verEncaminhamentos);
		
		logout = new JMenuItem("Sair");
		popupMenu.add(logout);
		
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
