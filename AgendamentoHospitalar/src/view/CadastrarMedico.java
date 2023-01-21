package view;

import control.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;

public class CadastrarMedico implements ActionListener {
	public JFrame container;
	private JTextField txtEmail;
	private JButton criarConta;
	private JTextField txtNome;
	private JTextField txtCadastrar;
	private JTextField txtEspecialidade;
	private JLabel lblEspecialidade;
	private JTextField txtCrm;
	private JLabel lblCrm;
	private JPanel panel;
	
	public CadastrarMedico(){
		container = new JFrame("Cadastro");
		container.getContentPane().setForeground(new Color(255, 255, 255));
		criarConta = new JButton("Criar Conta");
		criarConta.setBackground(new Color(9, 69, 108));
		criarConta.setBounds(171, 216, 139, 30);
		criarConta.addActionListener(new ActionListener() {
					
			
	//botao cadastrar
			public void actionPerformed(ActionEvent e) {
				String nome, email, especialidade, crm;
				
				

				nome = txtNome.getText();
				email = txtEmail.getText();
				especialidade = txtEspecialidade.getText();
				crm = txtCrm.getText();
				
				
				Medico medicos = new Medico();
				medicos.setNome(nome);
				medicos.setEmail(email);
				medicos.setEspecialidade(especialidade);
				medicos.setCrm(crm);
				
			
				ControlMedico medicocontrol = new ControlMedico();
				medicocontrol.cadastrar(medicos);
			}

		});
		txtEmail = new JTextField(25);
		txtEmail.setBounds(287, 108, 187, 24);
		
		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("CadastrarMedico");
		container.setSize(490, 325);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		criarConta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		criarConta.setForeground(new Color(255, 255, 255));
		container.getContentPane().setLayout(null);
		container.getContentPane().add(txtEmail);
		container.getContentPane().add(criarConta);
		
		txtNome = new JTextField(25);
		txtNome.setBounds(10, 108, 187, 24);
		container.getContentPane().add(txtNome);
		
		JLabel lblData = new JLabel("Nome Completo");
		lblData.setForeground(new Color(9, 69, 108));
		lblData.setBounds(10, 71, 300, 30);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		container.getContentPane().add(lblData);
		
		txtEspecialidade = new JTextField();
		txtEspecialidade.setBounds(287, 167, 187, 24);
		container.getContentPane().add(txtEspecialidade);
		txtEspecialidade.setColumns(10);
		
		lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setForeground(new Color(9, 69, 108));
		lblEspecialidade.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEspecialidade.setBounds(287, 144, 97, 15);
		container.getContentPane().add(lblEspecialidade);
		
		txtCrm = new JTextField();
		txtCrm.setBounds(10, 166, 187, 24);
		txtCrm.setColumns(10);
		container.getContentPane().add(txtCrm);
		
		lblCrm = new JLabel("CRM");
		lblCrm.setForeground(new Color(9, 69, 108));
		lblCrm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCrm.setBounds(10, 140, 70, 15);
		container.getContentPane().add(lblCrm);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(9, 69, 108));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(289, 79, 70, 15);
		container.getContentPane().add(lblEmail);
		
		panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 514, 54);
		container.getContentPane().add(panel);
		
		JLabel lblCadastroMedico = new JLabel("CadastrarMedico");
		panel.add(lblCadastroMedico);
		lblCadastroMedico.setBackground(new Color(255, 255, 255));
		lblCadastroMedico.setForeground(new Color(255, 255, 255));
		lblCadastroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMedico.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		container.setVisible(true);
		criarConta.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new CadastrarMedico();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}