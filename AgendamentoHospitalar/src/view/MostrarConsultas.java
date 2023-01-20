package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class MostrarConsultas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarConsultas frame = new MostrarConsultas();
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
	public MostrarConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar Pagamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos pa = new Pagamentos();
				pa.setVisible(true);
	            this.dispose();	
			}
			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(173, 227, 156, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro ca = new Cadastro();
				ca.setVisible(true);
	            this.dispose();	
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(351, 227, 136, 34);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 766, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(100, 149, 237));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				
			},
			new String[] {
				"Paciente", "Especialidade", "valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setBounds(497, 227, 136, 34);
		contentPane.add(btnNewButton_2);
	}
}
