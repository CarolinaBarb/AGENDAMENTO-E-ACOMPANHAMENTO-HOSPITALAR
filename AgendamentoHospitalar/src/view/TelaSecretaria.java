package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaSecretaria extends JFrame {

	private JPanel contentPane;
	private JTextField TextCodigo;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSecretaria frame = new TelaSecretaria();
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
	public TelaSecretaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsulta = new JButton("Marcar consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcarConsulta mc = new MarcarConsulta();
				mc.setVisible(true);
				dispose(); 
			}
		});
		btnConsulta.setBounds(10, 35, 173, 30);
		contentPane.add(btnConsulta);
		
		JButton btnDisponibilidade = new JButton("Adicionar disponibilidades");
		btnDisponibilidade.setBounds(10, 224, 173, 30);
		btnDisponibilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcarDisponibilidade md = new MarcarDisponibilidade();
				md.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnDisponibilidade);
		
		JButton btnPagamento = new JButton("Adicionar Pagamento");
		btnPagamento.setBounds(10, 135, 173, 30);
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos pg = new Pagamentos();
				pg.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnPagamento);
		
		JLabel lblNewLabel = new JLabel("Consultas existentes");
		lblNewLabel.setBounds(264, 35, 196, 13);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("código: ");
		lblNewLabel_1.setBounds(586, 26, 73, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		TextCodigo = new JTextField();
		TextCodigo.setBounds(641, 34, 49, 19);
		TextCodigo.setEnabled(false);
		contentPane.add(TextCodigo);
		TextCodigo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 71, 426, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(176, 196, 222));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Paciente", "Medico", "Especialidade", "Data", "Hora", "Valor"
			}
		));
		scrollPane.setViewportView(table);
	}
}
