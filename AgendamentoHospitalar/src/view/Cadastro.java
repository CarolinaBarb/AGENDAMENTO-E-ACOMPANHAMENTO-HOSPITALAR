package view;

import control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.*;
import model.*
;public class Cadastro implements ActionListener {
	JFrame container;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;
	private JTextField textField;
	private JTextField txtCadastrar;
	

	public Cadastro(ControlDados d){
		container = new JFrame("Cadastro");
		criarConta = new JButton("Criar Conta");
		criarConta.addActionListener(new ActionListener() {
			
	ControlPaciente cp = new ControlPaciente();		
			
	//boatao cadastrar
			public void actionPerformed(ActionEvent e) {
				Paciente paciente = new Paciente();
				
				paciente.setNome(textField.getText());
				paciente.setEmail(inserirEmail.getText());
				paciente.setSenha(inserirSenha.getText());
				
				//tentar salvar
				
				if(cp.salvar(paciente)) {
					JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso");
					Login lm = new Login(null);
				    lm.setVisible(true);
                    this.dispose();	
				}
		
				else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente");
				}
			}

			private void dispose() {
			}
		});
		
		emailLabel = new JLabel ("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
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
		criarConta.setBounds(167, 393, 139, 30);
		
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
		
		JLabel lblCadastroMedico = new JLabel("Cadastro");
		lblCadastroMedico.setBackground(new Color(72, 209, 204));
		lblCadastroMedico.setForeground(new Color(153, 50, 204));
		lblCadastroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMedico.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblCadastroMedico.setBounds(100, 48, 300, 30);
		container.getContentPane().add(lblCadastroMedico);
		
	
		
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
	
}