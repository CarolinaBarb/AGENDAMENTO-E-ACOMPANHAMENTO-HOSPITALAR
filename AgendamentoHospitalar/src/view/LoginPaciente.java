package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import control.ControlPaciente;
import model.Paciente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPaciente extends JFrame {

	private JPanel contentPane;
	public static JTextField inserirEmail;
	private JTextField inserirSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPaciente frame = new LoginPaciente();
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
	public LoginPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 461, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Paciente");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 10, 442, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(0, 235, 436, 13);
		contentPane.add(lblNewLabel_1);
		
		inserirEmail = new JTextField();
		inserirEmail.setBounds(70, 258, 302, 19);
		contentPane.add(inserirEmail);
		inserirEmail.setColumns(25);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(0, 303, 436, 13);
		contentPane.add(lblNewLabel_2);
		
		inserirSenha = new JPasswordField();
		inserirSenha.setBounds(70, 326, 302, 19);
		contentPane.add(inserirSenha);
		inserirSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
			}
		});
		btnEntrar.setBounds(165, 393, 110, 21);
		contentPane.add(btnEntrar);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBounds(341, 461, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		Image image = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(image.getScaledInstance(148, 148, Image.SCALE_SMOOTH)));
		lblNewLabel_3.setBounds(10, 68, 416, 145);
		contentPane.add(lblNewLabel_3);
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
			   TelaPaciente tp = new TelaPaciente();
			   tp.listarValoresPaciente(nome_usuario);
			   tp.setVisible(true);
	            dispose();
			   
		   }
		   else {
			   //enviar msg dizendo incorreto
			   JOptionPane.showMessageDialog(null, "email ou senha invalido");
		   }
		
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"FRMLoginPacienteView" +erro);
			
					}

	}

	public JTextField getInserirEmail() {
		return inserirEmail;
}
}

