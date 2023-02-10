package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlAdministrador;
import control.ControlFuncionario;
import model.Funcionario;
import model.Receita;
import model.Recibo;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerarRecibo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textData;
	private JTextField textDescricao;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarRecibo frame = new GerarRecibo();
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
	public GerarRecibo() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(-20, 0, 538, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GerarRecibo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 8, 377, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(11, 56, 113, 13);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBounds(11, 71, 348, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Total");
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(15, 137, 98, 13);
		contentPane.add(lblNewLabel_2);
		
		textValor = new JTextField();
		textValor.setBounds(14, 156, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(127, 139, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textData = new JTextField();
		textData.setBounds(125, 156, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição");
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(13, 181, 69, 13);
		contentPane.add(lblNewLabel_4);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(12, 203, 345, 60);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		
		JButton btnNewButton = new JButton("GerarRecibo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarRecibo();
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setBounds(125, 293, 149, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Email Paciente");
		lblNewLabel_5.setForeground(new Color(0, 64, 128));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(12, 96, 109, 13);
		contentPane.add(lblNewLabel_5);
		
		textEmail = new JTextField();
		textEmail.setBounds(11, 112, 349, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria pag = new TelaSecretaria();
				pag.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 64, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(292, 314, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	private void GerarRecibo() {
		String nome,email, valor, data,descricao;
		
		nome = textNome.getText();
		email = textEmail.getText();
		valor = textValor.getText();
		data = textData.getText();
		descricao = textDescricao.getText();
		
		Recibo objRecibo = new Recibo();
		objRecibo.setNome(nome);
		objRecibo.setEmail_Paciente(email);
		objRecibo.setValorTotal(valor);
		objRecibo.setData(data);
		objRecibo.setDescricao(descricao);
		
		
		ControlFuncionario objcontrolfun = new ControlFuncionario();
		objcontrolfun.GerarRecibo(objRecibo);
		
		
	}
}
