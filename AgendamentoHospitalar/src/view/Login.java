package view;

import control.*;
//import imagem.*;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Login implements ActionListener {
	JFrame container;
	private JButton btnEntrar;
	private JTextField inserirEmail;
	private JPasswordField inserirSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	/**
	 * @wbp.nonvisual location=-17,14
	 */
	private final JPanel panel = new JPanel();
	private JPanel panel_1;
	private JButton btnTelaPrincipal;

	public Login() {
		container = new JFrame("Login");
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(179, 439, 120, 30);
		btnEntrar.setBackground(new Color(9, 69, 108));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Verdana", Font.BOLD, 12));
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(100, 260, 300, 30);
		emailLabel.setForeground(new Color(9, 69, 108));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setBounds(100, 334, 300, 30);
		senhaLabel.setForeground(new Color(9, 69, 108));
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inserirEmail = new JTextField(25);
		inserirEmail.setBounds(100, 292, 300, 30);
		inserirSenha = new JPasswordField(25);
		inserirSenha.setBounds(100, 366, 300, 30);

		container.getContentPane().setBackground(new Color(255, 255, 255));
		container.setTitle("Login");
		container.setSize(500, 610);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		senhaLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		container.getContentPane().setLayout(null);
		
		container.getContentPane().add(emailLabel);
		container.getContentPane().add(inserirEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(inserirSenha);
		container.getContentPane().add(btnEntrar);
								
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(9, 69, 108));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 509, 53);
		container.getContentPane().add(panel_1);
								
		JLabel lblLogin = new JLabel("Login Paciente");
	    panel_1.add(lblLogin);
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBackground(new Color(234, 42, 21));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(179, 70, 156, 178);
		container.getContentPane().add(lblNewLabel);
		
		btnTelaPrincipal = new JButton("Tela Principal");
		btnTelaPrincipal.setForeground(new Color(255, 255, 255));
		btnTelaPrincipal.setBackground(new Color(9, 69, 108));
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnTelaPrincipal.setBounds(330, 533, 146, 30);
		container.getContentPane().add(btnTelaPrincipal);

		container.setVisible(true);

		btnEntrar.addActionListener(this);

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
			   TelaPaciente tp = new TelaPaciente();
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

