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
import control.ControlConsulta;
import model.Consulta;
import model.Consulta;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MostrarConsultas extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textPaciente;
	private JTextField textMedico;
	private JTextField textEspecialidade;
	private JTextField textHorario;
	private JTextField textValor;
	private JTextField textData;
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
		setBounds(100, 100, 904, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setBounds(173, 237, 136, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValoresC();
				limpar();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresC();
			}
		});
	
		
		textCodigo = new JTextField();
		textCodigo.setBounds(367, 11, 96, 19);
		textCodigo.setEnabled(false);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("codigo");
		lblNewLabel.setBounds(312, 17, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnCarregarCampos = new JButton("Carregar Campos");
		btnCarregarCampos.setBounds(746, 13, 130, 20);
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		contentPane.add(btnCarregarCampos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(793, 262, 85, 21);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(10, 45, 96, 13);
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPaciente);
		
		textPaciente = new JTextField();
		textPaciente.setBounds(78, 39, 224, 19);
		contentPane.add(textPaciente);
		textPaciente.setColumns(10);
		
		JLabel lblEspecialidae = new JLabel("Especialidade");
		lblEspecialidae.setBounds(10, 91, 96, 13);
		lblEspecialidae.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblEspecialidae);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(10, 68, 72, 13);
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		lblHorario.setBounds(10, 142, 72, 13);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblHorario);
		
		textHorario = new JTextField();
		textHorario.setBounds(77, 141, 96, 19);
		contentPane.add(textHorario);
		textHorario.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 171, 45, 13);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(50, 170, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 114, 45, 13);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(50, 114, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setBounds(651, 13, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(); 
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(10, 237, 136, 30);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresC();
			}
		});
		contentPane.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 40, 536, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Paciente", "Medico", "Especialidade", "Horario", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
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
						lista.get(num).getEmail(),
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
		int id;
		
		id = Integer.parseInt(textCodigo.getText());
		
		Consulta objconsulta = new Consulta();
		objconsulta.setID(id);
		
		ControlConsulta objcontrolconsulta = new ControlConsulta();
		objcontrolconsulta.excluirconsultas(objconsulta);
		
		
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
