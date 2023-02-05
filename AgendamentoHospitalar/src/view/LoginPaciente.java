package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlPaciente;
import model.Paciente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
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
		setBounds(100, 100, 450, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(0, 0, 436, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Paciente");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 416, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 199, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		inserirEmail = new JTextField();
		inserirEmail.setBounds(10, 222, 397, 19);
		contentPane.add(inserirEmail);
		inserirEmail.setColumns(25);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 251, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		inserirSenha = new JTextField();
		inserirSenha.setBounds(10, 283, 397, 19);
		contentPane.add(inserirSenha);
		inserirSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
			}
		});
		btnEntrar.setBounds(192, 346, 85, 21);
		contentPane.add(btnEntrar);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(351, 438, 85, 21);
		contentPane.add(btnNewButton_1);
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

