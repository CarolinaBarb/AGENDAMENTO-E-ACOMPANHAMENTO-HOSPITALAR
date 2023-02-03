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

public class LoginAdmin extends JFrame {
	JFrame container;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JPanel panel;
	private JButton btnEntrar;
	private JLabel lblNewLabel_1;
	private JButton Cadastrar;
	private JButton btnTelaPrincipal;


	public LoginAdmin() {
		container = new JFrame("Login");
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
		container.setSize(500, 558);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		senhaLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		container.getContentPane().setLayout(null);

		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 61);
		panel.setBackground(new Color(9, 69, 108));
		container.getContentPane().add(panel);
		
				JLabel lblLogin = new JLabel("Login Administrador");
				lblLogin.setForeground(new Color(255, 255, 255));
				panel.add(lblLogin);
				lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogin.setFont(new Font("Verdana", Font.BOLD, 20));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(172, 71, 223, 152);
				lblNewLabel.setForeground(new Color(0, 0, 255));
				Image img = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
				lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(148, 148, Image.SCALE_SMOOTH)));
				container.getContentPane().add(lblNewLabel);
				
				btnEntrar = new JButton("Entrar");
				btnEntrar.setBackground(new Color(9, 69, 108));
				btnEntrar.setForeground(new Color(255, 255, 255));
				btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 10));
				btnEntrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String email_adm;
							String senha_adm;
							
							email_adm = inserirEmail.getText();
							senha_adm = inserirSenha.getText();
							
							Administrador objAdministrador = new Administrador();
							objAdministrador.setEmail(email_adm);
							objAdministrador.setSenha(senha_adm);
							
							ControlAdministrador objadm = new ControlAdministrador();
							ResultSet rsAdm = objadm.autenticacaoAdministrador(objAdministrador);
							
							if(rsAdm.next()) {
								TelaAdmin ta = new TelaAdmin();
								ta.setVisible(true);
								dispose();
							}
						} catch (SQLException erro) {
							JOptionPane.showMessageDialog(null, "login adm" + erro);
						}
						
						

					}
				});
				btnEntrar.setBounds(191, 415, 110, 21);
				container.getContentPane().add(btnEntrar);
				
				lblNewLabel_1 = new JLabel("ou");
				lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
				lblNewLabel_1.setForeground(new Color(9, 69, 108));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(222, 446, 45, 13);
				container.getContentPane().add(lblNewLabel_1);
				
				Cadastrar = new JButton("Cadastre-se");
				Cadastrar.setBackground(new Color(9, 69, 108));
				Cadastrar.setForeground(new Color(255, 255, 255));
				Cadastrar.setFont(new Font("Verdana", Font.PLAIN, 10));
				Cadastrar.setBounds(191, 469, 110, 21);
				container.getContentPane().add(Cadastrar);
				
				btnTelaPrincipal = new JButton("Tela Principal");
				btnTelaPrincipal.setBackground(new Color(9, 69, 108));
				btnTelaPrincipal.setForeground(new Color(255, 255, 255));
				btnTelaPrincipal.setFont(new Font("Verdana", Font.PLAIN, 10));
				btnTelaPrincipal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaPrincipal tp = new TelaPrincipal();
						tp.setVisible(true);
					}
				});
				btnTelaPrincipal.setBounds(10, 71, 120, 21);
				container.getContentPane().add(btnTelaPrincipal);

		container.setVisible(true);

	}



	public static void main(String[] args) {
		new LoginAdmin();
	}
	
	

}
