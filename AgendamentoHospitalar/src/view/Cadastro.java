package view;

import java.util.*;
import control.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import control.*;
import model.*;

import com.toedter.calendar.JDateChooser;

public class Cadastro implements ActionListener {
	public JFrame container;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel senhaLabel;
	private JButton criarConta;
	private JTextField txtNome;
	private JTextField txtCadastrar;
	private JTextField txtSexo;
	private JTextField txtAltura;
	private JTextField txtObservacao;
	private JTextField txtPeso;
	private JLabel lblObservacao;
	private JTextField txtCpf;
	private JLabel lblCpf;
	private JDateChooser txtData;
	private JPanel panel;
	private JButton btnNewButton;
	
	public Cadastro(){
		container = new JFrame("Cadastro");
		container.getContentPane().setForeground(new Color(255, 255, 255));
		criarConta = new JButton("Criar Conta");
		criarConta.setBackground(new Color(9, 69, 108));
		criarConta.setBounds(186, 405, 139, 30);
		criarConta.addActionListener(new ActionListener() {
					
			
	//botao cadastrar
			public void actionPerformed(ActionEvent e) {
				String nome, email, senha, sexo, observacao, cpf;
				String  altura, peso;
				
				String DataNascimento = ((JTextField)txtData.getDateEditor().getUiComponent()).getText();
				
				

				nome = txtNome.getText();
				email = txtEmail.getText();
				senha = txtSenha.getText();
				sexo = txtSexo.getText();
				altura =txtAltura.getText();
				peso = txtPeso.getText();
				observacao = txtObservacao.getText();
				cpf = txtCpf.getText();
				
				
				Paciente pacientes = new Paciente();
				pacientes.setNome(nome);
				pacientes.setEmail(email);
				pacientes.setSenha(senha);
				pacientes.setSexo(sexo);
				pacientes.setDataNascimento(DataNascimento);
				pacientes.setAltura(altura);
				pacientes.setPeso(peso);
				pacientes.setObservacao(observacao);
				pacientes.setCpf(cpf);
				
			
				ControlPaciente pacientecontrol = new ControlPaciente();
				pacientecontrol.cadastrar(pacientes);
			}

		});
		senhaLabel = new JLabel("Senha");
		senhaLabel.setForeground(new Color(9, 69, 108));
		senhaLabel.setBounds(287, 132, 300, 30);
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail = new JTextField(25);
		txtEmail.setBounds(287, 108, 187, 24);
		txtSenha = new JPasswordField(25);
		txtSenha.setBounds(287, 166, 187, 24);
		
		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("Cadastro");
		container.setSize(500, 543);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		criarConta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		criarConta.setForeground(new Color(255, 255, 255));
		senhaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		container.getContentPane().setLayout(null);
		container.getContentPane().add(txtEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(txtSenha);
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
		
		txtSexo = new JTextField(25);
		txtSexo.setBounds(10, 354, 186, 24);
		container.getContentPane().add(txtSexo);
		
		txtAltura = new JTextField(25);
		txtAltura.setBounds(10, 289, 186, 24);
		container.getContentPane().add(txtAltura);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(9, 69, 108));
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSexo.setBounds(10, 329, 70, 15);
		container.getContentPane().add(lblSexo);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 199, 170, 15);
		container.getContentPane().add(lblNewLabel);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setForeground(new Color(9, 69, 108));
		lblAltura.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAltura.setBounds(10, 264, 70, 15);
		container.getContentPane().add(lblAltura);
		
		txtObservacao = new JTextField();
		txtObservacao.setBounds(287, 289, 187, 24);
		container.getContentPane().add(txtObservacao);
		txtObservacao.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(287, 225, 187, 24);
		container.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(9, 69, 108));
		lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPeso.setBounds(287, 200, 70, 15);
		container.getContentPane().add(lblPeso);
		
		lblObservacao = new JLabel("Observação");
		lblObservacao.setForeground(new Color(9, 69, 108));
		lblObservacao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblObservacao.setBounds(287, 264, 97, 15);
		container.getContentPane().add(lblObservacao);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(10, 166, 187, 24);
		txtCpf.setColumns(10);
		container.getContentPane().add(txtCpf);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(9, 69, 108));
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCpf.setBounds(10, 140, 70, 15);
		container.getContentPane().add(lblCpf);
		
		txtData = new JDateChooser();
		txtData.setForeground(new Color(9, 69, 108));
		txtData.setBackground(new Color(0, 0, 128));
		txtData.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtData.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtData.getCalendarButton().setBackground(new Color(9, 69, 108));
		txtData.setDateFormatString("d '/' MM '/' y");
		txtData.setBounds(10, 224, 186, 24);
		container.getContentPane().add(txtData);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(9, 69, 108));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(289, 79, 70, 15);
		container.getContentPane().add(lblEmail);
		
		panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 496, 54);
		container.getContentPane().add(panel);
		
		JLabel lblCadastroMedico = new JLabel("Cadastro");
		panel.add(lblCadastroMedico);
		lblCadastroMedico.setBackground(new Color(255, 255, 255));
		lblCadastroMedico.setForeground(new Color(255, 255, 255));
		lblCadastroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMedico.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		btnNewButton = new JButton("Tela Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
			}
		});
		btnNewButton.setBounds(349, 472, 127, 24);
		container.getContentPane().add(btnNewButton);
		
		container.setVisible(true);
		criarConta.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new Cadastro();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}