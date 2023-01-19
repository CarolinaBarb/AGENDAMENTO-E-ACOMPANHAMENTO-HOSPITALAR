package view;

import control.*;

import model.*;
//import imagem.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

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
		btnEntrar.setBounds(184, 408, 120, 30);
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.setForeground(new Color(255, 255, 255));
		
			
		
		btnEntrar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(100, 233, 300, 30);
		emailLabel.setForeground(new Color(9, 69, 108));
		emailLabel.setBackground(new Color(9, 69, 108));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setBounds(100, 313, 300, 30);
		senhaLabel.setForeground(new Color(9, 69, 108));
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inserirEmail = new JTextField(25);
		inserirEmail.setBounds(100, 271, 300, 30);
		inserirSenha = new JPasswordField(25);
		inserirSenha.setBounds(100, 353, 300, 30);

		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("Login");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		container.getContentPane().setLayout(null);

		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(btnEntrar);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 61);
		panel.setBackground(new Color(9, 69, 108));
		container.getContentPane().add(panel);
		
				JLabel lblLogin = new JLabel("Login Médico");
				lblLogin.setForeground(new Color(255, 255, 255));
				panel.add(lblLogin);
				lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(172, 71, 223, 152);
				lblNewLabel.setForeground(new Color(0, 0, 255));
				Image img = new ImageIcon(this.getClass().getResource("/imagem/doctor.png")).getImage();
				lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(148, 148, Image.SCALE_SMOOTH)));
				container.getContentPane().add(lblNewLabel);

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



	@Override
	public void actionPerformed(ActionEvent e) {
		LoginMedico lm = new LoginMedico();
		lm.setVisible(true);
		this.dispose();
		
	}
	private void dispose() {
	}
}
