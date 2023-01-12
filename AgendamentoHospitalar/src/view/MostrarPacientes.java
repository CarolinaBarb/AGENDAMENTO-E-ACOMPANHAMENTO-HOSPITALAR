package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlPaciente;
import model.Medico;
import model.Paciente;

public class MostrarPacientes extends JDialog {
	
	ControlPaciente cp;
	
	

	public MostrarPacientes(java.awt.Frame parent, boolean modal, ControlPaciente cp) {
		super(parent, modal);
		this.cp = cp;
		
		exibeInformacoes();
	}

	private void exibeInformacoes(){
		ArrayList<Paciente> pacientes = cp.retornarTodos();
		
		//limpar JTable
		
		for(int i = 0; i < 500; i++) {
			//linha i coluna 0
			table.setValueAt(null, i, 0);
			table.setValueAt(null, i, 1);	
		}
		// add informacoes
		for(int i = 0; i < pacientes.size() && pacientes.get(i) != null; i++) {
			//linha i coluna 0
			table.setValueAt(pacientes.get(i).getNome(), i, 0);
			table.setValueAt(pacientes.get(i).getEmail(), i, 1);	
		}
	}
	
	
	
	
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarPacientes dialog = new MostrarPacientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarPacientes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Nome", "Email"
				}
			));
			contentPanel.add(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						this.dispose();
					}

					private void dispose() {
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
