package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import model.Consulta;

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
		setBounds(100, 100, 714, 391);
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
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setBounds(602, 17, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Secretária");
		lblNewLabel_2.setBounds(289, 14, 149, 21);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setBackground(new Color(45, 84, 123));
		btnSelecionar.setBounds(592, 309, 85, 21);
		contentPane.add(btnSelecionar);
	}
	public void listarValores() {
		try {
			ControlConsulta objcontrolconsulta = new ControlConsulta();
			DefaultTableModel  model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista1 = objcontrolconsulta.PesquisarConsulta();
			for(int num = 0;num < lista1.size();num++ ) {
				model.addRow(new Object[] {
					lista1.get(num).getID(),
					lista1.get(num).getIdPaciente(),
					lista1.get(num).getIdMedico(),
					lista1.get(num).getEspecialidade(),
					lista1.get(num).getHorario(),
					lista1.get(num).getValor(),
					lista1.get(num).getData(),
				});
			}
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores Consulta" + erro);
		}
		
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		TextCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
	}
}
