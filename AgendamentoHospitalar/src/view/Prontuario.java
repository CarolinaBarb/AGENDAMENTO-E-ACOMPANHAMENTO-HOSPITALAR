package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import control.ControlPaciente;
import model.Consulta;
import model.Paciente;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prontuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prontuario frame = new Prontuario();
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
	
	public Prontuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 758);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Informações do Paciente:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(16, 54, 240, 25);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 807, 54);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Data de nascimento", "CPF", "Altura", "Peso", "Sexo", "email", "Observacao"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(124);
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(9, 69, 108));
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNome.setBounds(17, 141, 45, 13);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(15, 159, 374, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setBounds(17, 183, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(16, 201, 373, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Observação:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setBounds(413, 143, 104, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(414, 158, 405, 64);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Exames:");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(19, 240, 128, 13);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 263, 679, 73);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo de exame", "Profissional Respons\u00E1vel", "Nome do Paciente", "Motivo para encaminhamento"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(94);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(137);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(109);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(179);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de exame:");
		lblNewLabel_5.setForeground(new Color(9, 61, 108));
		lblNewLabel_5.setBackground(new Color(9, 61, 108));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(17, 346, 91, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setBounds(721, 262, 98, 21);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(16, 363, 374, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Profissional Responsável:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_6.setForeground(new Color(9, 61, 108));
		lblNewLabel_6.setBounds(16, 392, 145, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(16, 411, 373, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Motivo para o encaminhamento:");
		lblNewLabel_7.setForeground(new Color(9, 61, 108));
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(413, 348, 220, 13);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(413, 363, 406, 64);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Consultas realizadas:");
		lblNewLabel_8.setForeground(new Color(9, 61, 108));
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(16, 440, 193, 25);
		contentPane.add(lblNewLabel_8);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(19, 466, 679, 45);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medico", "Especialidade", "Data", "Hor\u00E1rio", "Valor", "Diagn\u00F3stico", "Observa\u00E7\u00E3o"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_1 = new JButton("Selecionar ");
		btnNewButton_1.setBackground(new Color(9, 61, 108));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBounds(721, 465, 103, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Médico:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_9.setForeground(new Color(9, 61, 108));
		lblNewLabel_9.setBounds(29, 521, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setBounds(24, 538, 365, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Especialidade:");
		lblNewLabel_10.setForeground(new Color(9, 61, 108));
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(27, 567, 81, 13);
		contentPane.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(25, 584, 364, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Diagnóstico:");
		lblNewLabel_11.setForeground(new Color(9, 61, 108));
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(427, 521, 76, 13);
		contentPane.add(lblNewLabel_11);
		
		textField_8 = new JTextField();
		textField_8.setBounds(424, 538, 395, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Observação:\r\n");
		lblNewLabel_12.setForeground(new Color(9, 61, 108));
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(424, 567, 93, 13);
		contentPane.add(lblNewLabel_12);
		
		textField_9 = new JTextField();
		textField_9.setBounds(424, 580, 395, 54);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPaciente lg = new LoginPaciente();
				lg.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(9, 61, 108));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.setBounds(372, 671, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 852, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Prontuário");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void listarValoresProntuarioPaciente(String email) {
		try {
			ControlPaciente objcontrolpaciente = new ControlPaciente();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Paciente> lista = objcontrolpaciente.PacienteProntuario(email);
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getNome(),
						lista.get(num).getIdade(),
						lista.get(num).getDataNascimento(),
						lista.get(num).getCpf(),
						lista.get(num).getAltura(),
						lista.get(num).getPeso(),
						lista.get(num).getSexo(),
						lista.get(num).getEmail(),
						lista.get(num).getObservacao()
						
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores View:" + erro);
		}
	}
	public void listarValoresProntuarioConsulta(String email) {
		try {
			ControlConsulta objcontrolconsulta = new ControlConsulta();
			DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			model.setNumRows(0);

			ArrayList<Consulta> lista = objcontrolconsulta.ProntuarioConsulta(email);
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdMedico(),
						lista.get(num).getEspecialidade(),
						lista.get(num).getHorario(),
						lista.get(num).getData(),
						lista.get(num).getValor(),
						lista.get(num).getDiagnostico(),
						lista.get(num).getObs(),
	
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores View:" + erro);
		}
	}
	
}
