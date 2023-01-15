package view;

import control.*;

import model.*;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ActionListener {
	JFrame container;
	private JButton btnEntrar;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;

	public Login() {
		container = new JFrame("Login");
		btnEntrar = new JButton("Entrar");
		criarConta = new JButton("Criar Conta");
		criarConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cadastro lm = new Cadastro();
				lm.container.setVisible(true);
				this.dispose();
			}

			private void dispose() {
			}
		});
		btnEntrar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		criarConta.setHorizontalAlignment(SwingConstants.CENTER);
		inserirEmail = new JTextField(25);
		inserirSenha = new JPasswordField(25);

		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("Login");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);

		btnEntrar.setBounds(188, 267, 120, 30);

		criarConta.setFont(new Font("Arial", Font.BOLD, 14));
		criarConta.setForeground(new Color(0, 0, 0));
		criarConta.setBounds(100, 349, 300, 30);

		inserirEmail.setBounds(100, 130, 300, 30);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		emailLabel.setBounds(100, 90, 300, 30);

		inserirSenha.setBounds(100, 210, 300, 30);
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setBounds(100, 170, 300, 30);

		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(btnEntrar);
		container.getContentPane().add(criarConta);

		JLabel lblClienteNovo = new JLabel("É paciente novo e não possui cadastro? Cadastra-se aqui:");
		lblClienteNovo.setHorizontalAlignment(SwingConstants.LEFT);
		lblClienteNovo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblClienteNovo.setBounds(78, 320, 374, 30);
		container.getContentPane().add(lblClienteNovo);

		JLabel lblLogin = new JLabel("Login Paciente");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblLogin.setBounds(89, 11, 300, 30);
		container.getContentPane().add(lblLogin);

		container.setVisible(true);

		btnEntrar.addActionListener(this);
		criarConta.addActionListener(this);

	}

	void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
       Logar();
	}

	private void Logar() {
		
		try {
			String nome_usuario, senha_usuario;
		
		    nome_usuario = inserirEmail.getText();
		    senha_usuario = inserirSenha.getText();
		
		   Paciente objpacientemodel = new Paciente();
		   objpacientemodel.setEmail(nome_usuario);
		   objpacientemodel.setSenha(senha_usuario);
		   
		   ControlPaciente objpacientecontrol = new ControlPaciente();
		   ResultSet rspaciente = objpacientecontrol.autenticacaoPaciente(objpacientemodel); //resultset tipo
		   
		   if(rspaciente.next()) {
			   //chamar tela q eu quero abrir
			   TelaHomePaciente tp = new TelaHomePaciente();
			    tp.setVisible(true);
	            dispose();
			   
		   }
		   else {
			   //enviar msg dizendo incorreto
			   JOptionPane.showMessageDialog(null, "email ou senha invalido");
		   }
		
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"FRMLoginView" +erro);
			
					}

	}

	private void dispose() {
	}

}
