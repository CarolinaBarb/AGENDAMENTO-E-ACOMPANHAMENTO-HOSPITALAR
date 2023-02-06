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

public class Receitas extends JFrame {

	private JPanel contentPane;
	private JTextField textmedicamento;
	private JTextField textdosagem;
	private JTextField texthorario;
	private JTextField textnome;
	private JTextField textDias;
	private JTextField texttomar;
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
		setBounds(100, 100, 458, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceita.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReceita.setBounds(10, 10, 424, 47);
		contentPane.add(lblReceita);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setBounds(10, 192, 90, 13);
		contentPane.add(lblMedicamento);
		
		textmedicamento = new JTextField();
		textmedicamento.setBounds(83, 189, 335, 19);
		contentPane.add(textmedicamento);
		textmedicamento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dosagem receitada: ");
		lblNewLabel.setBounds(10, 215, 116, 13);
		contentPane.add(lblNewLabel);
		
		textdosagem = new JTextField();
		textdosagem.setBounds(101, 212, 64, 19);
		contentPane.add(textdosagem);
		textdosagem.setColumns(10);
		
		JLabel lblTomar = new JLabel("Tomar");
		lblTomar.setHorizontalAlignment(SwingConstants.LEFT);
		lblTomar.setBounds(10, 238, 45, 13);
		contentPane.add(lblTomar);
		
		JLabel lblNewLabel_1 = new JLabel("Vezes ao dia");
		lblNewLabel_1.setBounds(114, 238, 116, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(10, 261, 45, 13);
		contentPane.add(lblHorario);
		
		texthorario = new JTextField();
		texthorario.setBounds(58, 258, 42, 19);
		contentPane.add(texthorario);
		texthorario.setColumns(10);
		
		JLabel lblDias = new JLabel("Dias");
		lblDias.setBounds(236, 220, 45, 13);
		contentPane.add(lblDias);
		
		JButton GerarReceita = new JButton("Gerar Receita");
		GerarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_paciente, medicamento, dosagem, horario, dias,email_paciente, medico;
				String tomar;
				
				nome_paciente = textnome.getText();
				email_paciente = textEmail.getText();
				medicamento = textmedicamento.getText();
				dosagem = textdosagem.getText();
				tomar = texttomar.getText();
				horario = texthorario.getText();
				dias = textDias.getText();
				medico = textMedico.getText();
				
				
				Receita objreceita = new Receita();
				objreceita.setNomePaciente(nome_paciente);
				objreceita.setMedicoResp(medico);
				objreceita.setEmail(email_paciente);
				objreceita.setMedicamento(medicamento);
				objreceita.setDosagemReceitada(dosagem);
				objreceita.setTomarVezes(tomar);
				objreceita.setHorario(horario);
				objreceita.setDias(dias);
				
				ControlReceitas objcontrolReceita = new ControlReceitas();
				objcontrolReceita.cadastrarReceita(objreceita);
				
			}
		});
		GerarReceita.setBounds(158, 307, 127, 31);
		contentPane.add(GerarReceita);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(349, 382, 85, 21);
		contentPane.add(Voltar);
		
		JLabel lblNome = new JLabel("Nome do paciente");
		lblNome.setBounds(10, 111, 90, 13);
		contentPane.add(lblNome);
		
		textnome = new JTextField();
		textnome.setBounds(114, 108, 304, 19);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		textDias = new JTextField();
		textDias.setBounds(273, 217, 145, 19);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		texttomar = new JTextField();
		texttomar.setBounds(58, 235, 42, 19);
		contentPane.add(texttomar);
		texttomar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Medico Responsável");
		lblNewLabel_2.setBounds(10, 50, 116, 13);
		contentPane.add(lblNewLabel_2);
		
		textMedico = new JTextField();
		textMedico.setBounds(114, 47, 304, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Informações do paciente");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 88, 250, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email do Paciente");
		lblNewLabel_4.setBounds(10, 134, 90, 13);
		contentPane.add(lblNewLabel_4);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 131, 304, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Prescrição");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(10, 169, 130, 13);
		contentPane.add(lblNewLabel_5);
	}
}
