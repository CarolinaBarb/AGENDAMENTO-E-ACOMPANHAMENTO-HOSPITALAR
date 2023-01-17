package view;

import control.*;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ActionListener {
	JFrame container;
	private JButton btnEntrar;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;
	/**
	 * @wbp.nonvisual location=-17,14
	 */
	private final JPanel panel = new JPanel();
	private JPanel panel_1;

	public Login() {
		container = new JFrame("Login");
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(191, 263, 120, 30);
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.setForeground(new Color(255, 255, 255));
		criarConta = new JButton("Criar Conta");
		criarConta.setBounds(100, 370, 300, 30);
		criarConta.setBackground(new Color(9, 69, 108));
		criarConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cadastro lm = new Cadastro();
				lm.container.setVisible(true);
				this.dispose();
			}

			private void dispose() {
			}
		});
		btnEntrar.setFont(new Font("Verdana", Font.BOLD, 12));
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(100, 77, 300, 30);
		emailLabel.setForeground(new Color(9, 69, 108));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setBounds(100, 154, 300, 30);
		senhaLabel.setForeground(new Color(9, 69, 108));
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		criarConta.setHorizontalAlignment(SwingConstants.CENTER);
		inserirEmail = new JTextField(25);
		inserirEmail.setBounds(100, 114, 300, 30);
		inserirSenha = new JPasswordField(25);
		inserirSenha.setBounds(100, 194, 300, 30);

		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("Login");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		criarConta.setFont(new Font("Verdana", Font.BOLD, 14));
		criarConta.setForeground(new Color(255, 255, 255));
		emailLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		senhaLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		container.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		String img = null;
		lblNewLabel.setIcon(new ImageIcon(img));
		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(btnEntrar);
		container.getContentPane().add(criarConta);

		JLabel lblClienteNovo = new JLabel(" Não possui cadastro? Cadastra-se aqui:");
		lblClienteNovo.setBounds(77, 316, 374, 30);
		lblClienteNovo.setForeground(new Color(9, 69, 108));
		lblClienteNovo.setHorizontalAlignment(SwingConstants.LEFT);
		lblClienteNovo.setFont(new Font("Verdana", Font.BOLD, 14));
		container.getContentPane().add(lblClienteNovo);
								
								panel_1 = new JPanel();
								panel_1.setBackground(new Color(9, 69, 108));
								panel_1.setForeground(new Color(255, 255, 255));
								panel_1.setBounds(-23, 0, 509, 53);
								container.getContentPane().add(panel_1);
								
										JLabel lblLogin = new JLabel("Login Paciente");
										panel_1.add(lblLogin);
										lblLogin.setForeground(new Color(255, 255, 255));
										lblLogin.setBackground(new Color(234, 42, 21));
										lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
										lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));

		container.setVisible(true);

		btnEntrar.addActionListener(this);
		criarConta.addActionListener(this);

	}

	void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
       Logar();
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
			   TelaHomePaciente tp = new TelaHomePaciente();
			    tp.setVisible(true);
	            dispose();
			   
		   }
		   else {
			   //enviar msg dizendo incorreto
			   JOptionPane.showMessageDialog(null, "email ou senha invalido");
		   }
		
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"FRMLoginView" +erro);
			
					}

	}

	private void dispose() {
	}
}

