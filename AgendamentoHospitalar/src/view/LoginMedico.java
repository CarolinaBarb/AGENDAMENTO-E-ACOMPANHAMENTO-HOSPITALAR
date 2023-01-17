package view;

import control.*;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMedico implements ActionListener {
	JFrame container;
	private JButton btnEntrar;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JPanel panel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public LoginMedico() {
		container = new JFrame("Login");
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		
			
		
		btnEntrar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(9, 69, 108));
		emailLabel.setBackground(new Color(9, 69, 108));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setForeground(new Color(9, 69, 108));
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inserirEmail = new JTextField(25);
		inserirSenha = new JPasswordField(25);

		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("Login");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);

		btnEntrar.setBounds(185, 304, 120, 30);

		inserirEmail.setBounds(100, 145, 300, 30);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		emailLabel.setBounds(100, 105, 300, 30);

		inserirSenha.setBounds(100, 237, 300, 30);
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setBounds(100, 197, 300, 30);

		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(btnEntrar);
		
		panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 486, 61);
		container.getContentPane().add(panel);
		
				JLabel lblLogin = new JLabel("Login Medico");
				lblLogin.setForeground(new Color(255, 255, 255));
				panel.add(lblLogin);
				lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogin.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));

		container.setVisible(true);

		btnEntrar.addActionListener(this);

	}

	void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new LoginMedico();
	}


	private void LogarMedico() {
		
		try {
			String email_medico, senha_medico;
		
		    email_medico = inserirEmail.getText();
		    senha_medico = inserirSenha.getText();
		
		   Medico medicomodel = new Medico();
		   medicomodel.setEmail(email_medico);
		   medicomodel.setSenha(senha_medico);
		   
		   ControlMedico medicocontrol = new ControlMedico();
		   ResultSet rsmedico = medicocontrol.autenticacaoMedico(medicomodel); //resultset tipo
		   
		   if(rsmedico.next()) {
			   //chamar tela q eu quero abrir
			   TelaMedico tp = new TelaMedico();
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


	@Override
	public void actionPerformed(ActionEvent e) {
		 LogarMedico();
		
	}
}
