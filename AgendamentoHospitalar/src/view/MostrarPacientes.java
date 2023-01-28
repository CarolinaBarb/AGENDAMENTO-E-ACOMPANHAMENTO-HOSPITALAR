package view;

import java.awt.EventQueue;
import java.lang.annotation.Target;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Color;

import control.*;
import model.Paciente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MostrarPacientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JTextField textCodigo;
	/**
	 * Launch the application.
	 */
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarPacientes frame = new MostrarPacientes();
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
	public MostrarPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		model = new DefaultTableModel();
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 92, 595, 123);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Idade", "CPF", "Altura", "Peso", "Sexo", "Observa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -18, 746, 53);
		panel.setBackground(new Color(9, 69, 108));
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro ca = new Cadastro();
				ca.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 95, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValores();
			}
		});
		btnNewButton_1.setBounds(10, 140, 85, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Carregar campos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_2.setBounds(614, 51, 122, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblCodigo = new JLabel("codigo");
		lblCodigo.setBounds(141, 55, 45, 13);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(180, 52, 51, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton Editar = new JButton("Editar");
		Editar.setBounds(10, 194, 85, 21);
		contentPane.add(Editar);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(651, 263, 85, 21);
		contentPane.add(btnNewButton_3);
		
		
		
	}
	public void listarValores() {
		try {
			ControlPaciente objcontrolpaciente = new ControlPaciente();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Paciente> lista = objcontrolpaciente.PesquisarPaciente();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdpaciente(),
						lista.get(num).getNome(),
						lista.get(num).getCpf(),
						lista.get(num).getAltura(),
						lista.get(num).getPeso(),
						lista.get(num).getDataNascimento(),
						lista.get(num).getSexo(),
						lista.get(num).getObservacao()
						
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores View:" + erro);
		}
	}
	private void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
	}
	private void excluir() {
		int id_paciente;
		
		id_paciente = Integer.parseInt(textCodigo.getText());
		Paciente objpaciente = new Paciente();
		objpaciente.setIdpaciente(id_paciente);
		
		ControlPaciente objcontrolpaciente = new ControlPaciente();
		objcontrolpaciente.excluirPaciente(objpaciente);
	}
}
