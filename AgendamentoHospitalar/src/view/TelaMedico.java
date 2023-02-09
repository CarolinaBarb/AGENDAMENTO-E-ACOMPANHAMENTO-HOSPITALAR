package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TelaMedico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textDiagnostico;
	private JLabel lblObservacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico frame = new TelaMedico();
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
	public TelaMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Selecione o Paciente:");
		lblPaciente.setForeground(new Color(9, 69, 108));
		lblPaciente.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPaciente.setBounds(10, 60, 163, 13);
		contentPane.add(lblPaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 280, 69);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(102, 153, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Nome", "Idade"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(242);
		scrollPane.setViewportView(table);
		
		JLabel lblDiagnostico = new JLabel("Diagnóstico:");
		lblDiagnostico.setForeground(new Color(9, 69, 108));
		lblDiagnostico.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDiagnostico.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiagnostico.setBounds(10, 174, 130, 13);
		contentPane.add(lblDiagnostico);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setBounds(10, 197, 280, 25);
		contentPane.add(textDiagnostico);
		textDiagnostico.setColumns(10);
		
		lblObservacao = new JLabel("Observações:");
		lblObservacao.setForeground(new Color(9, 69, 108));
		lblObservacao.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblObservacao.setBounds(10, 240, 98, 13);
		contentPane.add(lblObservacao);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.setBounds(365, 247, 171, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Encaminhar para exames");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encaminhamento en = new Encaminhamento();
				en.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(365, 139, 171, 32);
		contentPane.add(btnNewButton);
		
		JButton btnReceita = new JButton("Adicionar Receita");
		btnReceita.setForeground(new Color(255, 255, 255));
		btnReceita.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnReceita.setBackground(new Color(9, 69, 108));
		btnReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receitas r = new Receitas();
				r.setVisible(true);
				dispose();
			}
		});
		btnReceita.setBounds(365, 84, 171, 32);
		contentPane.add(btnReceita);
		
		JButton btnAtestado = new JButton("Atestado");
		btnAtestado.setForeground(new Color(255, 255, 255));
		btnAtestado.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnAtestado.setBackground(new Color(9, 69, 108));
		btnAtestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atestado at = new Atestado();
				at.setVisible(true);
				dispose();
			}
		});
		btnAtestado.setBounds(365, 193, 171, 32);
		contentPane.add(btnAtestado);
		
		JTextArea textObservações = new JTextArea();
		textObservações.setBackground(new Color(205, 225, 216));
		textObservações.setBounds(5, 265, 285, 93);
		contentPane.add(textObservações);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.setBackground(new Color(9, 69, 108));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMedico lm = new LoginMedico();
				lm.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setBounds(408, 348, 117, 25);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 548, 39);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Médico");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
	}
}
