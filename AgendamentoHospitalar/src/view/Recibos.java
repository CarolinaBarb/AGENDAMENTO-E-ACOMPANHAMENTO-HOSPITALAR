package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlFuncionario;
import model.Recibo;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recibos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textData;
	private JTextField textDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recibos frame = new Recibos();
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
	public Recibos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recibos");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 367, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista De Pagamentos Realizados");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 60, 243, 13);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 393, 92);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Valor Total", "Data", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton.setBounds(316, 56, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 187, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textNome = new JTextField();
		textNome.setBounds(10, 205, 390, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor Total");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(11, 234, 109, 13);
		contentPane.add(lblNewLabel_3);
		
		textValor = new JTextField();
		textValor.setBounds(10, 252, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(120, 235, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textData = new JTextField();
		textData.setBounds(121, 253, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Descrição");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(222, 236, 81, 13);
		contentPane.add(lblNewLabel_5);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(223, 253, 175, 49);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBackground(new Color(0, 64, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(145, 346, 135, 21);
		contentPane.add(btnNewButton_1);
	}
	public void listarValores(String email) {
		try {
		ControlFuncionario objcontrolFuncionario = new ControlFuncionario();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		
		ArrayList<Recibo> Lista1 = objcontrolFuncionario.PacienteRecibo(email);
		
		for(int num = 0; num < Lista1.size(); num++) {
			model.addRow(new Object[] {
					Lista1.get(num).getNome(),
					Lista1.get(num).getValorTotal(),
					Lista1.get(num).getData(),
					Lista1.get(num).getDescricao(),
			});
		}
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "listar valores recibos" + erro);
		}
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textNome.setText(table.getModel().getValueAt(setar, 0).toString());
		textValor.setText(table.getModel().getValueAt(setar, 1).toString());
		textData.setText(table.getModel().getValueAt(setar, 2).toString());
		textDescricao.setText(table.getModel().getValueAt(setar, 3).toString());
	}
}

