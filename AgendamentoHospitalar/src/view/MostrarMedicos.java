package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlMedico;
import control.ControlPaciente;
import model.Medico;
import model.Paciente;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MostrarMedicos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarMedicos frame = new MostrarMedicos();
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
	public MostrarMedicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 202, 333, -146);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 77, 639, 137);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"id", "Nome", "Email", "crm", "Especialidade"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cadastrar novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro ca = new Cadastro();
				ca.container.setVisible(true);
				dispose();
			}

			
		});
		btnNewButton.setBounds(55, 252, 177, 33);
		contentPane.add(btnNewButton);
		
		JButton Excluir = new JButton("Excluir");
		Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresM();
			}
		});
		Excluir.setBounds(261, 252, 186, 33);
		contentPane.add(Excluir);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 21, 45, 13);
		contentPane.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setEnabled(false);
		textCodigo.setBounds(10, 37, 54, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("carregar campos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_1.setBounds(481, 252, 111, 33);
		contentPane.add(btnNewButton_1);
	}
	
	public void listarValoresM() {
		try {
			ControlMedico objcontrolmedico = new ControlMedico();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Medico> lista = objcontrolmedico.PesquisarMedico();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getNome(),
						lista.get(num).getEmail(),
						lista.get(num).getCrm(),
						lista.get(num).getEspecialidade()
						
				});
			}
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores View:" + erro);
}
	
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigo.setText(table.getModel().getValueAt(setar, 1).toString());
	}
	
	public void excluir() {
		int id_Medico;
		
		id_Medico = Integer.parseInt(textCodigo.getText());
		
		Medico objmedico = new Medico();
		objmedico.setIdmedico(id_Medico);
		
		ControlMedico objcontrolMedico = new ControlMedico();
		objcontrolMedico.excluirMedico(objmedico);
		
	}
}

