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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 444, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(110, 238, 207, 37);
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(93, 273, 259, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(191, 318, 63, 12);
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(93, 342, 259, 19);
		contentPane.add(passwordSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(176, 393, 85, 21);
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
		btnTelaPrincipal.setBounds(301, 453, 109, 21);
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
		
		JLabel lblNewLabel_3 = new JLabel("Login Secretária");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        Image image2 = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
        lblNewLabel_2.setIcon(new ImageIcon(image2.getScaledInstance(148, 148, Image.SCALE_SMOOTH)));
		lblNewLabel_2.setBounds(135, 75, 164, 151);
		contentPane.add(lblNewLabel_2);
		
	
	}
}
