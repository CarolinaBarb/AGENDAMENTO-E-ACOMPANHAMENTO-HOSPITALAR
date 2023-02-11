package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import control.ControlFuncionario;
import control.ControlMedico;

import model.Consulta;
import model.Medico;
import model.Privado;

import javax.swing.JTextArea;

public class PagPrivado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JTextField textCodigo;
	private JTextField textValor;
	private JTextField textData;
	private JTextField textParcelamento;
	private JTextField textTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagPrivado frame = new PagPrivado();
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
	public PagPrivado() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Parcelamento");
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(292, 60, 127, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Forma de Pagamento");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(290, 140, 188, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Gerar Recibo");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarRecibo gr = new GerarRecibo();
				gr.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(246, 246, 173, 29);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 431, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Privado");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos pag = new Pagamentos();
				pag.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(new Color(45, 84, 123));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(334, 303, 85, 21);
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 274, 50);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Valor", "Data"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		scrollPane.setViewportView(table);
		
		textNome = new JTextField();
		textNome.setBounds(10, 85, 229, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(240, 85, 42, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Registrar Pagamento");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPagamento();
			}
		});
		btnNewButton_1.setBackground(new Color(45, 84, 123));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 246, 210, 29);
		contentPane.add(btnNewButton_1);
		
		textValor = new JTextField();
		textValor.setBounds(10, 129, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(45, 84, 123));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 69, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setForeground(new Color(45, 84, 123));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 115, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Data");
		lblNewLabel_5.setForeground(new Color(45, 84, 123));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(118, 116, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textData = new JTextField();
		textData.setBounds(117, 129, 163, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		textParcelamento = new JTextField();
		textParcelamento.setBounds(292, 85, 96, 19);
		contentPane.add(textParcelamento);
		textParcelamento.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(292, 163, 96, 19);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
	}

	public void listarValoresPagamento(String id) {
		try {
			ControlConsulta objpesquisarConsulta = new ControlConsulta();
			
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista = objpesquisarConsulta.PacientePagamento(id);
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getID(),
						lista.get(num).getIdPaciente(),
						lista.get(num).getData(),
						lista.get(num).getValor(),
						
				});
			}
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Listar Valores  Paciente View:" + erro);
			
		}
		
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textNome.setText(table.getModel().getValueAt(0, 3).toString());
		textCodigo.setText(table.getModel().getValueAt(0, 0).toString());
		
		
	}
	public void RegistrarPagamento() {
		String nome = textNome.getText();
		String data = textData.getText();
		String valor = textValor.getText();
		String tipo = textTipo.getText();
		String parcelas = textParcelamento.getText();
		
		Privado privado = new Privado(0, "", "", "");
		privado.setNome(nome);
		privado.setDataPagamento(data);
		privado.setValor(valor);
		privado.setTipo(tipo);
		privado.setParcelas(parcelas);
		
		ControlFuncionario objcontrolPag = new ControlFuncionario();
		objcontrolPag.RegistrarPagamentoPriv(privado);
		
	}
}
