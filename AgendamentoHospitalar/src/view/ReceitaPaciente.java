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

public class ReceitaPaciente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textMedico;
	private JTextField textNomePaciente;
	private JTextField textMedicamento;
	private JTextField textDosagem;
	private JTextField textVezes;
	private JTextField textHorario;
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
		ListarValoresReceita(TelaPaciente.textEmail.getText());
		if(ControlReceitas.lista.isEmpty()){
	        
        }else{
        	textNomePaciente.setText(ControlReceitas.lista.get(0).getEmail());
            //System.out.println("vazio");
        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(201, 10, 0, 0);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 526, 139);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Medico", "Paciente", "Medicamento", "Dosagem", "Vezes ao dia", "Horario", "Dias"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(65);
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Selecionar Receita");
		lblNewLabel.setBounds(10, 42, 163, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnSelecionar = new JButton("selecionar");
		btnSelecionar.setBounds(451, 34, 85, 21);
		contentPane.add(btnSelecionar);
		
		JLabel lblNewLabel_1 = new JLabel("Informações da receita");
		lblNewLabel_1.setBounds(10, 214, 191, 13);
		contentPane.add(lblNewLabel_1);
		
		textMedico = new JTextField();
		textMedico.setEnabled(false);
		textMedico.setBounds(10, 254, 227, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Medico");
		lblNewLabel_2.setBounds(10, 237, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome do Paciente");
		lblNewLabel_3.setBounds(10, 281, 93, 13);
		contentPane.add(lblNewLabel_3);
		
		textNomePaciente = new JTextField();
		textNomePaciente.setEnabled(false);
		textNomePaciente.setBounds(10, 304, 227, 19);
		contentPane.add(textNomePaciente);
		textNomePaciente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Medicamento");
		lblNewLabel_4.setBounds(272, 237, 77, 13);
		contentPane.add(lblNewLabel_4);
		
		textMedicamento = new JTextField();
		textMedicamento.setEnabled(false);
		textMedicamento.setBounds(272, 254, 227, 19);
		contentPane.add(textMedicamento);
		textMedicamento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dosagem receitada");
		lblNewLabel_5.setBounds(272, 281, 133, 13);
		contentPane.add(lblNewLabel_5);
		
		textDosagem = new JTextField();
		textDosagem.setEnabled(false);
		textDosagem.setBounds(272, 304, 77, 19);
		contentPane.add(textDosagem);
		textDosagem.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tomar");
		lblNewLabel_6.setBounds(373, 307, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textVezes = new JTextField();
		textVezes.setEnabled(false);
		textVezes.setBounds(409, 304, 37, 19);
		contentPane.add(textVezes);
		textVezes.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("ao dia");
		lblNewLabel_7.setBounds(456, 307, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Horario");
		lblNewLabel_8.setBounds(272, 333, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		textHorario = new JTextField();
		textHorario.setEnabled(false);
		textHorario.setBounds(272, 356, 45, 19);
		contentPane.add(textHorario);
		textHorario.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Dias");
		lblNewLabel_9.setBounds(342, 333, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		textDias = new JTextField();
		textDias.setEnabled(false);
		textDias.setBounds(342, 356, 157, 19);
		contentPane.add(textDias);
		textDias.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPaciente lp = new LoginPaciente();
				lp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(201, 428, 148, 21);
		contentPane.add(btnVoltar);
	}
	public void ListarValoresReceita(String email){
		try {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			ControlReceitas objcontrolreceita = new ControlReceitas();

			ArrayList<Receita> lista = objcontrolreceita.PacienteReceita(email);
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdreceita(),
						lista.get(num).getNomePaciente(),
						lista.get(num).getMedicoResp(),
						lista.get(num).getEmail(),
						lista.get(num).getMedicamento(),
						lista.get(num).getDosagemReceitada(),
						lista.get(num).getTomarVezes(),
						lista.get(num).getHorario(),
						lista.get(num).getDias(),
				});
			}
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Listar Valores  Paciente View:" + erro);
			
		}
	}
}
