package view;

import control.*;
import model.Paciente;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.*;

public class Login implements ActionListener {
	JFrame container;
	private JButton botao;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;
	
	public Login(ControlDados d){
		container = new JFrame("Login");
		botao = new JButton("Entrar");
		criarConta = new JButton("Criar Conta");
		criarConta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Cadastro lm = new Cadastro();
				lm.container.setVisible(true);
                this.dispose();
			}

			private void dispose() {	
			}
		});
		botao.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		emailLabel = new JLabel ("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		criarConta.setHorizontalAlignment(SwingConstants.CENTER);
		inserirEmail = new JTextField(25);
		inserirSenha = new JPasswordField(25);
		
		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("Login");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		botao.setBounds(186,268,120,30);
		
		criarConta.setFont(new Font("Arial", Font.BOLD, 14));
		criarConta.setForeground(new Color(0, 0, 0));
		criarConta.setBounds(100, 349, 300, 30);
		
		inserirEmail.setBounds(100, 130, 300, 30);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		emailLabel.setBounds(100, 90, 300, 30);
		
		inserirSenha.setBounds(100, 210, 300, 30);
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setBounds(100, 170, 300, 30);
		
		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(botao);
		container.getContentPane().add(criarConta);
		
		JLabel lblClienteNovo = new JLabel("É paciente novo e não possui cadastro? Cadastra-se aqui:");
		lblClienteNovo.setHorizontalAlignment(SwingConstants.LEFT);
		lblClienteNovo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblClienteNovo.setBounds(78, 320, 374, 30);
		container.getContentPane().add(lblClienteNovo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Paciente");
		rdbtnNewRadioButton.setBounds(100, 63, 109, 23);
		container.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMedico = new JRadioButton("Medico");
		rdbtnMedico.setBounds(244, 63, 109, 23);
		container.getContentPane().add(rdbtnMedico);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblLogin.setBounds(89, 11, 300, 30);
		container.getContentPane().add(lblLogin);
		
		container.setVisible(true);
		
		botao.addActionListener(this);
		criarConta.addActionListener(this);

	}

	void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Login(null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src == botao)
			new TelaHomePaciente();
		if(src == criarConta)
			new Cadastro();
		
	}
	
	
	public void actionPerformed1(ActionEvent e) {
		if(logar(null, inserirEmail.getText(), inserirSenha.getText())) {

			//case 1:
			TelaHomePaciente tp = new TelaHomePaciente();
		    tp.setVisible(true);
            this.dispose();
            
			//case 2:
				//TelaMedico tm = new TelaMedico();
			    //tm.setVisible(true);
	            //this.dispose();
            
		}
		else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel realizar o login");
		}
		
	}
	   public boolean logar(ControlDados d, String email,String senha) {
	       	Paciente paciente = new Paciente(email, senha);
	       	if(validaLoginPacient(d, email, senha)) { 
	       		return true;
	        	}else {
	        }
	       	paciente.setPaciente(paciente);
	       	return Dados.paciente.add(paciente);
	       }

	   public boolean validaLoginPacient(ControlDados d, String email, String senha) {
			boolean loginvalidP = false;
			String senhaP = "";
			for(int i = 0; i < d.getQtPaciente(); i++ ) {
				if(d.getPaciente()[i].getEmail().equals(email)) {
					loginvalidP = true;
				}
			}
			for(int i = 0; i < d.getQtPaciente(); i++) {
				if(d.getPaciente()[i].getEmail().equals(email)) {
					senhaP = d.getPaciente()[i].getSenha();
				}
			}
			return loginvalidP;
		}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
