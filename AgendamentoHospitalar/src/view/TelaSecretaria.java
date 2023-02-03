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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsulta = new JButton("Marcar consulta");
		btnConsulta.setForeground(new Color(255, 255, 255));
		btnConsulta.setBackground(new Color(9, 69, 108));
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcarConsulta mc = new MarcarConsulta();
				mc.setVisible(true);
				dispose(); 
			}
		});
		btnConsulta.setBounds(10, 88, 173, 30);
		contentPane.add(btnConsulta);
		
		JButton btnDisponibilidade = new JButton("Adicionar disponibilidades");
		btnDisponibilidade.setForeground(new Color(255, 255, 255));
		btnDisponibilidade.setBackground(new Color(9, 69, 108));
		btnDisponibilidade.setBounds(10, 245, 173, 30);
		btnDisponibilidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcarDisponibilidade md = new MarcarDisponibilidade();
				md.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnDisponibilidade);
		
		JButton btnPagamento = new JButton("Adicionar Pagamento");
		btnPagamento.setForeground(new Color(255, 255, 255));
		btnPagamento.setBackground(new Color(9, 69, 108));
		btnPagamento.setBounds(10, 166, 173, 30);
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos pg = new Pagamentos();
				pg.setVisible(true);
				pg.listarValoresP();
				dispose();
			}
		});
		contentPane.add(btnPagamento);
		
		JLabel lblNewLabel = new JLabel("Consultas existentes");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setBounds(251, 88, 196, 13);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("código: ");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setBounds(554, 71, 73, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		TextCodigo = new JTextField();
		TextCodigo.setBounds(615, 79, 62, 19);
		TextCodigo.setEnabled(false);
		contentPane.add(TextCodigo);
		TextCodigo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 116, 426, 183);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 715, 48);
		contentPane.add(panel);
	}
}
