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

public class MostrarMedicos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
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
		scrollPane_1.setBounds(10, 31, 639, 183);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Email", "crm", "Especialidade"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cadastrar novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro ca = new Cadastro();
				ca.container.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnNewButton.setBounds(115, 252, 177, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir existente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(362, 252, 186, 33);
		contentPane.add(btnNewButton_1);
	}

}
