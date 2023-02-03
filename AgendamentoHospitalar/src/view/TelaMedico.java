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

public class TelaMedico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textDiagnostico;
	private JLabel lblObservacao;
	private JTextField textObservacao;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Selecione o Paciente ");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaciente.setBounds(10, 37, 163, 13);
		contentPane.add(lblPaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 280, 80);
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
		
		JLabel lblDiagnostico = new JLabel("Diagnóstico");
		lblDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiagnostico.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiagnostico.setBounds(10, 150, 130, 13);
		contentPane.add(lblDiagnostico);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setBounds(10, 173, 280, 33);
		contentPane.add(textDiagnostico);
		textDiagnostico.setColumns(10);
		
		lblObservacao = new JLabel("Observações");
		lblObservacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblObservacao.setBounds(10, 216, 98, 13);
		contentPane.add(lblObservacao);
		
		textObservacao = new JTextField();
		textObservacao.setBounds(12, 236, 277, 89);
		contentPane.add(textObservacao);
		textObservacao.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setBounds(365, 281, 171, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Encaminhar para exames");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encaminhamento en = new Encaminhamento();
				en.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(365, 136, 171, 44);
		contentPane.add(btnNewButton);
		
		JButton btnReceita = new JButton("Adicionar Receita");
		btnReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receitas r = new Receitas();
				r.setVisible(true);
				dispose();
			}
		});
		btnReceita.setBounds(365, 60, 171, 44);
		contentPane.add(btnReceita);
		
		JButton btnAtestado = new JButton("Atestado");
		btnAtestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atestado at = new Atestado();
				at.setVisible(true);
				dispose();
			}
		});
		btnAtestado.setBounds(365, 214, 171, 44);
		contentPane.add(btnAtestado);
	}
}
