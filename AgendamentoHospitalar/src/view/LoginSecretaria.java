package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlFuncionario;
import model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginSecretaria extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSecretaria frame = new LoginSecretaria();
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
	public LoginSecretaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(0, 93, 410, 35);
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(93, 138, 259, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(184, 200, 63, 13);
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(93, 236, 259, 19);
		contentPane.add(passwordSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(174, 288, 85, 21);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String email_secretaria;
					String senha_secretaria;
					
					email_secretaria = textUsuario.getText();
					senha_secretaria = passwordSenha.getText();
					
					Funcionario objSecretaria = new Funcionario();
					objSecretaria.setEmail(email_secretaria);
					objSecretaria.setSenha(senha_secretaria);
					
					ControlFuncionario objsecretaria = new ControlFuncionario();
					ResultSet rssecretaria = objsecretaria.autenticacaoSecretaria(objSecretaria);
					
					if(rssecretaria.next()) {
						TelaSecretaria tl = new TelaSecretaria();
						tl.setVisible(true);
						tl.listarValores();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalida");
					}
					
				}catch(SQLException erro){
					JOptionPane.showMessageDialog(null, "login secretaria" + erro);
					
				}

			}
		});
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(btnEntrar);
		
		JButton btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.setBounds(311, 354, 109, 21);
		btnTelaPrincipal.setForeground(new Color(255, 255, 255));
		btnTelaPrincipal.setBackground(new Color(9, 69, 108));
		btnTelaPrincipal.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnTelaPrincipal);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 430, 67);
		panel.setBackground(new Color(9, 69, 108));
		contentPane.add(panel);
	}
	
		
	
}
