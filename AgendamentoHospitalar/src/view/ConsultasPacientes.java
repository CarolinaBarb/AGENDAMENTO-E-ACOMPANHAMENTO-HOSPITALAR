package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import control.ControlMedico;
import model.Consulta;
import model.Medico;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ConsultasPacientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textCodigo;
	private JTextField ColocarNome;

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
	public ConsultasPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 60, 751, 146);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(100, 149, 237));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paciente", "Codigo", "Especialidade", "valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnMostrar = new JButton("mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValoresC(IdPaciente);
			}
		});
		btnMostrar.setBounds(588, 22, 127, 34);
		contentPane.add(btnMostrar);
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(25, 30, 96, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("codigo");
		lblNewLabel.setBounds(25, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		ColocarNome = new JTextField();
		ColocarNome.setBounds(170, 7, 114, 19);
		contentPane.add(ColocarNome);
		ColocarNome.setColumns(10);
	}
	
	private void listarValoresC(String IdPaciente) {
		try {
			ControlConsulta objconsulta = new ControlConsulta();
			
			DefaultTableModel  model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista = objconsulta.PacienteConsulta(IdPaciente);
			
			for(int num = 0; num < lista.size();num ++) {
				model.addRow(new Object[] {
						lista.get(num).getIdPaciente(),
						lista.get(num).getID(),
						lista.get(num).getEspecialidade(),
						lista.get(num).getHorario(),
						lista.get(num).getValor(),
						lista.get(num).getData()
				});
				
			}
			
			
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null, erro);
			
		}
	}
	private void excluir() {
		int id_consulta;
		
		id_consulta = Integer.parseInt(textCodigo.getText());
		
		Consulta objconsulta = new Consulta();
		objconsulta.setID(id_consulta);
		
		ControlConsulta objcontrolconsulta = new ControlConsulta();
		objcontrolconsulta.excluirConsulta(objconsulta);
		
		
	}
}
