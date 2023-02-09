package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlAdministrador;
import model.Administrador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAdm extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textDatanascimento;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JTextField textSexo;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAdm frame = new CadastroAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(9, 61, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 67, 45, 13);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(65, 66, 285, 14);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setForeground(new Color(9, 61, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 90, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textCPF = new JTextField();
		textCPF.setBounds(65, 89, 285, 13);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data Nascimento:");
		lblNewLabel_2.setForeground(new Color(9, 61, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 136, 121, 13);
		contentPane.add(lblNewLabel_2);
		
		textDatanascimento = new JTextField();
		textDatanascimento.setBounds(129, 137, 221, 14);
		contentPane.add(textDatanascimento);
		textDatanascimento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setForeground(new Color(9, 61, 108));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 159, 70, 13);
		contentPane.add(lblNewLabel_3);
		
		textEmail = new JTextField();
		textEmail.setBounds(65, 158, 285, 14);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setForeground(new Color(9, 61, 108));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 188, 51, 13);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(64, 187, 286, 14);
		contentPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(9, 61, 108));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, cpf, data_nascimento, email, senha, sexo;
				
				nome = textNome.getText();
				cpf = textCPF.getText();
				data_nascimento = textDatanascimento.getText();
				email = textEmail.getText();
				senha = passwordField.getText();
				sexo = textSexo.getText();
				
				Administrador objadm = new Administrador();
				objadm.setEmail(email);
				objadm.setNome(nome);
				objadm.setSexo(sexo);
				objadm.setDataNascimento(data_nascimento);
				objadm.setSenha(senha);
				objadm.setCpf(cpf);
				
				ControlAdministrador objcontroladm = new ControlAdministrador();
				objcontroladm.cadastrarAdm(objadm);
				
			}
		});
		btnCadastrar.setBounds(144, 234, 85, 21);
		contentPane.add(btnCadastrar);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnLogin.setBackground(new Color(9, 61, 108));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin la = new LoginAdmin();
				la.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(281, 276, 85, 21);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setForeground(new Color(9, 61, 108));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 113, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textSexo = new JTextField();
		textSexo.setBounds(65, 113, 285, 13);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 61, 108));
		panel.setBounds(0, 0, 376, 39);
		contentPane.add(panel);
		
		JLabel lblNewLabel_6 = new JLabel("Cadrastro");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	}
}
