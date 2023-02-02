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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 67, 410, 35);
		contentPane.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(93, 112, 259, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(194, 157, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(93, 194, 259, 19);
		contentPane.add(passwordSenha);
		
		JButton btnEntrar = new JButton("Entrar");
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
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalida");
					}
					
				}catch(SQLException erro){
					JOptionPane.showMessageDialog(null, "login secretaria" + erro);
					
				}

			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEntrar.setBounds(178, 272, 85, 21);
		contentPane.add(btnEntrar);
		
		JButton btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
				
			}
		});
		btnTelaPrincipal.setBounds(10, 10, 109, 21);
		contentPane.add(btnTelaPrincipal);
	}
	
		
	
}
