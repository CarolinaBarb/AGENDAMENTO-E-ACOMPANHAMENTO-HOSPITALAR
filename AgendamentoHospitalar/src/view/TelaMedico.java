package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlFuncionario;
import control.ControlPaciente;
import model.Consulta;
import model.Paciente;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TelaMedico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textDiagnostico;
	private JLabel lblObservacao;
	private JTextField textPaciente;
	private JTextField textObs;

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
		lblDiagnostico.setBounds(10, 208, 130, 13);
		contentPane.add(lblDiagnostico);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setBounds(10, 231, 280, 25);
		contentPane.add(textDiagnostico);
		textDiagnostico.setColumns(10);
		
		lblObservacao = new JLabel("Observações:");
		lblObservacao.setForeground(new Color(9, 69, 108));
		lblObservacao.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblObservacao.setBounds(10, 266, 98, 13);
		contentPane.add(lblObservacao);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
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
				GeraAtestado at = new GeraAtestado();
				at.setVisible(true);
				dispose();
			}
		});
		btnAtestado.setBounds(365, 193, 171, 32);
		contentPane.add(btnAtestado);
		
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
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(55, 72, 121));
		btnNewButton_2.setBounds(205, 57, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente:");
		lblNewLabel_1.setForeground(new Color(55, 72, 121));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 158, 98, 13);
		contentPane.add(lblNewLabel_1);
		
		textPaciente = new JTextField();
		textPaciente.setEnabled(false);
		textPaciente.setBounds(10, 173, 280, 25);
		contentPane.add(textPaciente);
		textPaciente.setColumns(10);
		
		textObs = new JTextField();
		textObs.setBackground(new Color(174, 196, 210));
		textObs.setBounds(10, 285, 280, 60);
		contentPane.add(textObs);
		textObs.setColumns(10);
	}
	public void ListarValoresMedico() {
		try {
			ControlPaciente objcontrolpaciente = new ControlPaciente();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Paciente> lista = objcontrolpaciente.PesquisarPaciente();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getNome(),
						lista.get(num).getIdade(),
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores View:" + erro);
		}
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		textPaciente.setText(table.getModel().getValueAt(setar, 0).toString());
	}
	private void cadastrar() {
		String nome, diagnostico, observacao;
		
		nome = textPaciente.getText();
		diagnostico = textDiagnostico.getText();
		observacao = textObs.getText();
		
		Consulta objconsulta = new Consulta();
		objconsulta.setIdPaciente(observacao);
		objconsulta.setDiagnostico(diagnostico);
		objconsulta.setObs(observacao);
		
		ControlFuncionario funcionarioControl = new ControlFuncionario();
		funcionarioControl.cadastrarConsulta(objconsulta);
		
		ListarValoresMedico();
}
}
