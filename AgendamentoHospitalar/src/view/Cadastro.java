package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.*;

public class Cadastro implements ActionListener {
	private JFrame container;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;
	private JTextField textField;
	private final Action action = new SwingAction();
	

	public Cadastro(ControlDados d){
		container = new JFrame("Cadastro");
		criarConta = new JButton("Criar Conta");
		criarConta.setAction(action);
		criarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		emailLabel = new JLabel ("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		criarConta.setHorizontalAlignment(SwingConstants.CENTER);
		inserirEmail = new JTextField(25);
		inserirSenha = new JPasswordField(25);
		
		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("Cadastro");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		criarConta.setFont(new Font("Arial", Font.BOLD, 14));
		criarConta.setForeground(new Color(0, 0, 0));
		criarConta.setBounds(100, 371, 300, 30);
		
		inserirEmail.setBounds(100, 238, 300, 30);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		emailLabel.setBounds(100, 197, 300, 30);
		
		inserirSenha.setBounds(100, 308, 300, 30);
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setBounds(100, 267, 300, 30);
		
		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(criarConta);
		
		textField = new JTextField(25);
		textField.setBounds(100, 156, 300, 30);
		container.getContentPane().add(textField);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompleto.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		lblNomeCompleto.setBounds(100, 115, 300, 30);
		container.getContentPane().add(lblNomeCompleto);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBackground(new Color(72, 209, 204));
		lblCadastro.setForeground(new Color(153, 50, 204));
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblCadastro.setBounds(100, 48, 300, 30);
		container.getContentPane().add(lblCadastro);
		
		container.setVisible(true);
		criarConta.addActionListener(this);

	}
	


	
	public static void main(String[] args) {
		new Cadastro(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
