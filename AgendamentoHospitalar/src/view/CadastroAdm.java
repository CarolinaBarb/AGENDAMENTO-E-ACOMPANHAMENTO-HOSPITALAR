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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 54, 45, 13);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(65, 53, 304, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 77, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textCPF = new JTextField();
		textCPF.setBounds(65, 76, 96, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data Nascimento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 123, 121, 13);
		contentPane.add(lblNewLabel_2);
		
		textDatanascimento = new JTextField();
		textDatanascimento.setBounds(131, 122, 96, 19);
		contentPane.add(textDatanascimento);
		textDatanascimento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 146, 70, 13);
		contentPane.add(lblNewLabel_3);
		
		textEmail = new JTextField();
		textEmail.setBounds(65, 146, 195, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 169, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(65, 169, 121, 19);
		contentPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(142, 225, 85, 21);
		contentPane.add(btnCadastrar);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin la = new LoginAdmin();
				la.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(281, 276, 85, 21);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 100, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textSexo = new JTextField();
		textSexo.setBounds(65, 99, 96, 19);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
	}
}
