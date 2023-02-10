package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import control.ControlReceitas;
import model.Consulta;
import model.Receita;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ReceitaPaciente extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textMedico;
	private JTextField textNomePaciente;
	private JTextField textMedicamento;
	private JTextField textDosagem;
	private JTextField textDias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceitaPaciente frame = new ReceitaPaciente();
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
	public ReceitaPaciente() {
		ListarValoresReceita(LoginPaciente.inserirEmail.getText());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 526, 139);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Medico", "Paciente", "Medicamento", "Dosagem", "Frequencia", "Dias"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(65);
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Selecionar Receita");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 42, 163, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnSelecionar = new JButton("selecionar");
		btnSelecionar.setBackground(new Color(0, 64, 128));
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setBounds(451, 40, 85, 15);
		contentPane.add(btnSelecionar);
		
		JLabel lblNewLabel_1 = new JLabel("Informações da receita");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 214, 191, 13);
		contentPane.add(lblNewLabel_1);
		
		textMedico = new JTextField();
		textMedico.setEnabled(false);
		textMedico.setBounds(10, 254, 227, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Medico");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_2.setBounds(10, 237, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome do Paciente");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_3.setBounds(10, 281, 174, 13);
		contentPane.add(lblNewLabel_3);
		
		textNomePaciente = new JTextField();
		textNomePaciente.setEnabled(false);
		textNomePaciente.setBounds(10, 304, 227, 19);
		contentPane.add(textNomePaciente);
		textNomePaciente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Medicamento");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setForeground(new Color(0, 64, 128));
		lblNewLabel_4.setBounds(272, 237, 77, 13);
		contentPane.add(lblNewLabel_4);
		
		textMedicamento = new JTextField();
		textMedicamento.setEnabled(false);
		textMedicamento.setBounds(272, 254, 227, 19);
		contentPane.add(textMedicamento);
		textMedicamento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dosagem receitada");
		lblNewLabel_5.setForeground(new Color(0, 64, 128));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(272, 281, 133, 13);
		contentPane.add(lblNewLabel_5);
		
		textDosagem = new JTextField();
		textDosagem.setEnabled(false);
		textDosagem.setBounds(272, 304, 77, 19);
		contentPane.add(textDosagem);
		textDosagem.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Frequência");
		lblNewLabel_8.setForeground(new Color(0, 64, 128));
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(274, 335, 86, 13);
		contentPane.add(lblNewLabel_8);
		
		textDias = new JTextField();
		textDias.setEnabled(false);
		textDias.setBounds(271, 353, 157, 19);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(0, 64, 128));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPaciente lp = new LoginPaciente();
				lp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(205, 412, 148, 21);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBounds(0, 0, 546, 32);
		contentPane.add(panel);
	}
	public void ListarValoresReceita(String email){
		try {
			ControlReceitas objcontrolreceita = new ControlReceitas();

			DefaultTableModel model = (DefaultTableModel)table_1.getModel();
			model.setNumRows(0);
			
			ArrayList<Receita> lista = objcontrolreceita.PacienteReceita(email);
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdreceita(),
						lista.get(num).getMedicoResp(),
						lista.get(num).getNomePaciente(),
						lista.get(num).getMedicamento(),
						lista.get(num).getDosagemReceitada(),
						lista.get(num).getFrequencia(),
				});
			}
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Listar Valores Receita View:" + erro);
			
		}
	}
}
