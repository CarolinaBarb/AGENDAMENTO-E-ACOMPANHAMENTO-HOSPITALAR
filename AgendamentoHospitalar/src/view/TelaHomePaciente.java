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
	private JButton prontuario;
	private JComboBox<String> comboBox;
	private JMenuItem logout, verReceitas, verAtestados, verEncaminhamentos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	
	public TelaHomePaciente(){
		
		container = new JFrame("Home");
		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("HomePaciente");
		container.setSize(1066, 639);
		container.setLocation(700, 700);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marcarconsulta = new JButton("Marcar Consultas");
		marcarconsulta.setBounds(36, 215, 216, 213);
		marcarconsulta.setForeground(new Color(255, 255, 255));
		marcarconsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		marcarconsulta.setFont(new Font("Verdana", Font.PLAIN, 20));
		marcarconsulta.setBackground(new Color(9, 69, 108));
		
		agendamento = new JButton("Agendamentos");
		agendamento.setBounds(287, 215, 216, 213);
		agendamento.setForeground(new Color(255, 255, 255));
		agendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		agendamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamento.setBackground(new Color(9, 69, 108));

		pagamentos = new JButton("Pagamentos");
		pagamentos.setBounds(540, 215, 216, 213);
		pagamentos.setForeground(new Color(255, 255, 255));
		pagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos pa = new Pagamentos();
				pa.setVisible(true);
	            this.dispose();	   
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		pagamentos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pagamentos.setBackground(new Color(9, 69, 108));
		
		prontuario = new JButton("Prontuario");
		prontuario.setBounds(792, 215, 216, 213);
		prontuario.setForeground(new Color(255, 255, 255));
		prontuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prontuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prontuario.setBackground(new Color(9, 69, 108));
		
        String[] items = {"Receitas", "Atestados", "Encaminhamentos", "Sair"};
		container.getContentPane().setLayout(null);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(941, 22, 101, 30);
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(9, 69, 108));
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

		
		container.getContentPane().add(marcarconsulta);
		container.getContentPane().add(agendamento);
		container.getContentPane().add(pagamentos);
		container.getContentPane().add(prontuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(-19, 0, 1117, 72);
		panel.setBackground(new Color(9, 69, 108));
		container.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(29, 0, 117, 73);
		panel.add(lblNewLabel_1);
		Image home11 = new ImageIcon(this.getClass().getResource("/home11.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(home11.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		
		
		container.setVisible(true);
		
		marcarconsulta.addActionListener(this);
		agendamento.addActionListener(this);
		pagamentos.addActionListener(this);
		prontuario.addActionListener(this);

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
