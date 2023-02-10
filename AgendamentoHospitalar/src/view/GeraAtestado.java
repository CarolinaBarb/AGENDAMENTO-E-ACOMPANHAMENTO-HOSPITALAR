package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlMedico;
import model.Atestado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GeraAtestado extends JFrame {

	private JPanel contentPane;
	private JTextField textJustificativa;
	private JTextField textNome;
	private JTextField textDias;
	private JTextField textRecomendacoes;
	private JTextField textValidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeraAtestado frame = new GeraAtestado();
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
	public GeraAtestado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Justificativa:");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 116, 122, 13);
		contentPane.add(lblNewLabel);
		
		textJustificativa = new JTextField();
		textJustificativa.setBounds(10, 139, 230, 43);
		contentPane.add(textJustificativa);
		textJustificativa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Paciente:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(9, 64, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBounds(136, 61, 177, 16);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de dias:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(9, 88, 154, 18);
		contentPane.add(lblNewLabel_2);
		
		textDias = new JTextField();
		textDias.setBounds(136, 88, 177, 18);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Recomendações:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setBounds(10, 192, 113, 13);
		contentPane.add(lblNewLabel_3);
		
		textRecomendacoes = new JTextField();
		textRecomendacoes.setBounds(8, 215, 227, 43);
		contentPane.add(textRecomendacoes);
		textRecomendacoes.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar Atestado");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAtestado();
			}
		});
		btnNewButton.setBounds(8, 348, 155, 21);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.setBackground(new Color(9, 69, 108));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(243, 348, 85, 21);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 338, 43);
		contentPane.add(panel);
		
		JLabel lblAtestado = new JLabel("Atestado");
		lblAtestado.setForeground(new Color(255, 255, 255));
		panel.add(lblAtestado);
		lblAtestado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtestado.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("Validade");
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(10, 268, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		textValidade = new JTextField();
		textValidade.setBounds(10, 291, 96, 19);
		contentPane.add(textValidade);
		textValidade.setColumns(10);
	}
	private void RegistrarAtestado() {
		String nome, dias, justificativa, recomendacoes, validade;
		
		nome = textNome.getText();
		dias = textDias.getText();
		justificativa = textJustificativa.getText();
		recomendacoes = textRecomendacoes.getText();
		validade = textValidade.getText();
		
		Atestado objatestado = new Atestado();
		objatestado.setNome(nome);
		objatestado.setQtdDias(dias);
		objatestado.setJustificativa(justificativa);
		objatestado.setRecomendacoes(recomendacoes);
		objatestado.setValidade(validade);
		
		ControlMedico atestadoControl = new ControlMedico();
		atestadoControl.cadastrarAtestado(objatestado);
		
	}

}
