package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlAdministrador;
import control.ControlMedico;
import model.Administrador;
import model.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMedico frame = new LoginMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 109, 307, 13);
		contentPane.add(lblUsuario);
		
		textEmail = new JTextField();
		textEmail.setBounds(69, 132, 193, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(10, 161, 307, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String email;
					String senha;
					
					email = textEmail.getText();
					senha = passwordField.getText();
					
					Medico objmedico = new Medico();
					objmedico.setEmail(email);
					objmedico.setSenha(senha);
					
					ControlMedico controlemedico = new ControlMedico();
					ResultSet rsmed = controlemedico.autenticacaoMedico(objmedico);
					
					if(rsmed.next()) {
						TelaMedico ta = new TelaMedico();
						ta.setVisible(true);
						dispose();
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "login adm" + erro);
				}
			}
		});
		btnEntrar.setBounds(122, 248, 85, 21);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 185, 193, 19);
		contentPane.add(passwordField);
		
		JButton btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnTelaPrincipal.setBounds(10, 10, 85, 21);
		contentPane.add(btnTelaPrincipal);
	}
	
}
