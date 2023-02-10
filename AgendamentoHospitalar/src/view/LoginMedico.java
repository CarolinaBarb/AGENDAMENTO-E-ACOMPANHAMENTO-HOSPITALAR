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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

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
		setBounds(100, 100, 336, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(9, 69, 108));
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(0, 234, 307, 13);
		contentPane.add(lblUsuario);
		
		textEmail = new JTextField();
		textEmail.setBounds(57, 257, 205, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(9, 69, 108));
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(0, 286, 307, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 10));
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
						ta.ListarValoresMedico();
						dispose();
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "login adm" + erro);
				}
			}
		});
		btnEntrar.setBounds(118, 361, 85, 21);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(57, 310, 205, 19);
		contentPane.add(passwordField);
		
		JButton btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.setForeground(new Color(255, 255, 255));
		btnTelaPrincipal.setBackground(new Color(9, 69, 108));
		btnTelaPrincipal.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnTelaPrincipal.setBounds(195, 412, 112, 21);
		contentPane.add(btnTelaPrincipal);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(42, 55, 230, 155);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Image image2 = new ImageIcon(this.getClass().getResource("/imagem/doctor.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(image2.getScaledInstance(148, 148, Image.SCALE_SMOOTH)));
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(9, 69, 108));
        panel.setBounds(0, 0, 327, 43);
        contentPane.add(panel);
	}
	
}
