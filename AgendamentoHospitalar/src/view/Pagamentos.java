package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import model.Consulta;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class Pagamentos extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	private JTable table;
	public static JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagamentos frame = new Pagamentos();
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
	public Pagamentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Consulta:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setBackground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 76, 181, 19);
		contentPane.add(lblNewLabel_1);
		
		textValor = new JTextField();
		textValor.setEnabled(false);
		textValor.setBounds(183, 77, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Informações da Consulta:\r\n");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(21, 161, 287, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Pagamento:");
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(442, 71, 214, 29);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Privado");
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagPrivado priv = new PagPrivado();
				priv.setVisible(true);
				priv.listarValoresPagamento(textCodigo.getText());
				priv.CarregarCampos();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(396, 134, 128, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Convênio");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagConvenio conv = new PagConvenio();
				conv.setVisible(true);
				conv.listarValoresPagamento(textCodigo.getText());
				conv.CarregarCampos();
				dispose();
			}
		});
		btnNewButton_1.setBounds(580, 135, 131, 84);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Data: ");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(21, 109, 74, 17);
		contentPane.add(lblNewLabel_4);
		
		textData = new JTextField();
		textData.setEnabled(false);
		textData.setBounds(69, 109, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 761, 48);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Pagamento");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.setForeground(new Color(255, 255, 255));
		Voltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		Voltar.setBackground(new Color(9, 69, 108));
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria tl = new TelaSecretaria();
				tl.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(618, 306, 133, 19);
		contentPane.add(Voltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 190, 287, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Medico", "Data", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.setBackground(new Color(9, 69, 108));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_2.setBounds(318, 301, 133, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(new Color(45, 84, 123));
		lblCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCodigo.setBounds(21, 137, 85, 19);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(93, 134, 45, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
	}
	
	public void listarValoresP() {
		try {
			ControlConsulta objcontrolConsulta = new ControlConsulta();
			
			DefaultTableModel Model = (DefaultTableModel) table.getModel();
			Model.setNumRows(0);
			
			ArrayList <Consulta> Lista = objcontrolConsulta.PesquisarConsulta();
			for(int num = 0; num < Lista.size(); num++) {
				Model.addRow(new Object[] {
						Lista.get(num).getID(),
						Lista.get(num).getIdPaciente(),
						Lista.get(num).getIdMedico(),
						Lista.get(num).getData(),
						Lista.get(num).getValor(),
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "listar valores Pagamentos" + erro);
		}
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textValor.setText(table.getModel().getValueAt(setar, 4).toString());
		textData.setText(table.getModel().getValueAt(setar, 3).toString());
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
	}
	public JTextField getInserirId() {
		return textCodigo;
}
}
