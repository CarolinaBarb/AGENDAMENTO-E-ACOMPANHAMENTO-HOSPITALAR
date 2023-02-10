package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import control.ControlReceitas;
import model.Medico;
import model.Receita;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;





public class Receitas extends JFrame {

	private JPanel contentPane;
	private JTextField textmedicamento;
	private JTextField textdosagem;
	private JTextField textfrequencia;
	private JTextField textnome;
	private JTextField textDias;
	private JTextField textMedico;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receitas frame = new Receitas();
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
	public Receitas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMedicamento = new JLabel("Medicamento:");
		lblMedicamento.setForeground(new Color(9, 69, 108));
		lblMedicamento.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblMedicamento.setBounds(6, 199, 90, 13);
		contentPane.add(lblMedicamento);
		
		textmedicamento = new JTextField();
		textmedicamento.setBounds(98, 196, 317, 19);
		contentPane.add(textmedicamento);
		textmedicamento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dosagem receitada: ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setBounds(6, 225, 116, 13);
		contentPane.add(lblNewLabel);
		
		textdosagem = new JTextField();
		textdosagem.setBounds(132, 225, 79, 16);
		contentPane.add(textdosagem);
		textdosagem.setColumns(10);
		
		JLabel lblHorario = new JLabel("Frequência:");
		lblHorario.setForeground(new Color(9, 69, 108));
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblHorario.setBounds(6, 248, 116, 13);
		contentPane.add(lblHorario);
		
		textfrequencia = new JTextField();
		textfrequencia.setBounds(98, 248, 90, 16);
		contentPane.add(textfrequencia);
		textfrequencia.setColumns(10);
		
		JLabel lblDias = new JLabel("Dias:");
		lblDias.setForeground(new Color(9, 69, 108));
		lblDias.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblDias.setBounds(234, 225, 45, 13);
		contentPane.add(lblDias);
		
		JButton GerarReceita = new JButton("Gerar Receita");
		GerarReceita.setForeground(new Color(255, 255, 255));
		GerarReceita.setBackground(new Color(9, 69, 108));
		GerarReceita.setFont(new Font("Verdana", Font.PLAIN, 10));
		GerarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_paciente, medicamento, dosagem, frequencia, dias,email_paciente, medico;
				
				nome_paciente = textnome.getText();
				email_paciente = textEmail.getText();
				medicamento = textmedicamento.getText();
				dosagem = textdosagem.getText();
				frequencia = textfrequencia.getText();
				dias = textDias.getText();
				medico = textMedico.getText();
				
				
				Receita objreceita = new Receita();
				objreceita.setNomePaciente(nome_paciente);
				objreceita.setMedicoResp(medico);
				objreceita.setEmail(email_paciente);
				objreceita.setMedicamento(medicamento);
				objreceita.setDosagemReceitada(dosagem);
				objreceita.setFrequencia(frequencia);
				objreceita.setDias(dias);
				
				ControlReceitas objcontrolReceita = new ControlReceitas();
				objcontrolReceita.cadastrarReceita(objreceita);
				
			}
		});
		GerarReceita.setBounds(158, 304, 127, 23);
		contentPane.add(GerarReceita);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.setForeground(new Color(255, 255, 255));
		Voltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		Voltar.setBackground(new Color(9, 69, 108));
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(349, 305, 85, 21);
		contentPane.add(Voltar);
		
		JLabel lblNome = new JLabel("Nome do paciente:");
		lblNome.setForeground(new Color(9, 69, 108));
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNome.setBounds(9, 124, 107, 13);
		contentPane.add(lblNome);
		
		textnome = new JTextField();
		textnome.setBounds(123, 121, 292, 19);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		textDias = new JTextField();
		textDias.setBounds(272, 225, 143, 16);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Médico Responsável:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(6, 78, 116, 13);
		contentPane.add(lblNewLabel_2);
		
		textMedico = new JTextField();
		textMedico.setBounds(132, 75, 283, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Informações do Paciente:");
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(9, 101, 250, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email do Paciente:");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(9, 147, 107, 13);
		contentPane.add(lblNewLabel_4);
		
		textEmail = new JTextField();
		textEmail.setBounds(123, 147, 292, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Prescrição:");
		lblNewLabel_5.setForeground(new Color(9, 69, 108));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(9, 176, 130, 13);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(-1, 4, 447, 43);
		contentPane.add(panel);
		
		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setForeground(new Color(255, 255, 255));
		panel.add(lblReceita);
		lblReceita.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceita.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	}
}
