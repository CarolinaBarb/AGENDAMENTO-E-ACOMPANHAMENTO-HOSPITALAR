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

public class MostrarConsultas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textPaciente;
	private JTextField textMedico;
	private JTextField textEspecialidade;
	private JTextField textHorario;
	private JTextField textValor;
	private JTextField textData;

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
		setBounds(100, 100, 904, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValoresC();
				limpar();
				
			}
		});
		btnNewButton_1.setBounds(173, 237, 136, 30);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 40, 562, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(100, 149, 237));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Paciente", "Medico", "Especialidade", "Horario", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresC();
			}
		});
	
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(367, 11, 96, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("codigo");
		lblNewLabel.setBounds(312, 17, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnCarregarCampos = new JButton("Carregar Campos");
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnCarregarCampos.setBounds(746, 13, 130, 20);
		contentPane.add(btnCarregarCampos);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresC();
			}
		});
		btnExcluir.setBounds(10, 237, 136, 30);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(793, 262, 85, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaciente.setBounds(10, 45, 96, 13);
		contentPane.add(lblPaciente);
		
		textPaciente = new JTextField();
		textPaciente.setBounds(78, 39, 224, 19);
		contentPane.add(textPaciente);
		textPaciente.setColumns(10);
		
		JLabel lblEspecialidae = new JLabel("Especialidade");
		lblEspecialidae.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEspecialidae.setBounds(10, 91, 96, 13);
		contentPane.add(lblEspecialidae);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMedico.setBounds(10, 68, 72, 13);
		contentPane.add(lblMedico);
		
		textMedico = new JTextField();
		textMedico.setBounds(78, 67, 224, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setBounds(103, 90, 136, 19);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHorario.setBounds(10, 142, 72, 13);
		contentPane.add(lblHorario);
		
		textHorario = new JTextField();
		textHorario.setBounds(77, 141, 96, 19);
		contentPane.add(textHorario);
		textHorario.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(10, 171, 45, 13);
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(50, 170, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(10, 114, 45, 13);
		contentPane.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(50, 114, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(); 
			}
		});
		btnNewButton.setBounds(651, 13, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	public void listarValoresC() {
		try {
			ControlConsulta objconsulta = new ControlConsulta();
			
			DefaultTableModel  model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista = objconsulta.PesquisarConsulta();
			
			for(int num = 0; num < lista.size();num ++) {
				model.addRow(new Object[] {
						lista.get(num).getID(),
						lista.get(num).getIdPaciente(),
						lista.get(num).getIdMedico(),
						lista.get(num).getEspecialidade(),
						lista.get(num).getHorario(),
						lista.get(num).getData(),
						lista.get(num).getValor(),
				});
				
			}
			
			
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null, erro);
			
		}
	}
	private void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
		textPaciente.setText(table.getModel().getValueAt(setar, 1).toString());
		textMedico.setText(table.getModel().getValueAt(setar, 2).toString());
		textEspecialidade.setText(table.getModel().getValueAt(setar, 3).toString());
		textHorario.setText(table.getModel().getValueAt(setar, 4).toString());
		textData.setText(table.getModel().getValueAt(setar, 5).toString());
		textValor.setText(table.getModel().getValueAt(setar, 6).toString());

	}
	private void excluir() {
		int id_consulta;
		
		id_consulta = Integer.parseInt(textCodigo.getText());
		
		Consulta objconsulta = new Consulta();
		objconsulta.setID(id_consulta);
		
		ControlConsulta objcontrolconsulta = new ControlConsulta();
		objcontrolconsulta.excluirConsulta(objconsulta);
		
		
	}
	private void limpar() {
		textCodigo.setText("");
		textPaciente.setText("");
		textMedico.setText("");
		textEspecialidade.setText("");
		textHorario.setText("");
		textData.setText("");
		textValor.setText("");
		
		
	}
	private void editar() {
		int ID;
		String paciente, medico, especialidade, horario, data, valor;
		
		ID = Integer.parseInt(textCodigo.getText());
		paciente = textPaciente.getText();
		medico = textMedico.getText();
		especialidade = textEspecialidade.getText();
		horario = textHorario.getText();
		data = textData.getText();
		valor = textValor.getText();
		
		Consulta objeditarconsulta = new Consulta();
		objeditarconsulta.setIdPaciente(paciente);
		objeditarconsulta.setIdMedico(medico);
		objeditarconsulta.setEspecialidade(especialidade);
		objeditarconsulta.setHorario(horario);
		objeditarconsulta.setData(data);
		objeditarconsulta.setValor(valor);
		objeditarconsulta.setID(ID);
		
		
		ControlConsulta objcontrolconsulta = new ControlConsulta();
		objcontrolconsulta.editarConsulta(objeditarconsulta);
		
		
	}
}
