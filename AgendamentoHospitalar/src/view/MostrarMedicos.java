package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import control.ControlMedico;
import control.ControlPaciente;
import model.Consulta;
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
	private JTextField textCodigoM;

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
		scrollPane_1.setBounds(242, 55, 407, 170);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nome", "Email", "crm", "Especialidade"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cadastrar novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMedico ca = new CadastrarMedico();
				ca.container.setVisible(true);
				dispose();
			}

			
		});
		btnNewButton.setBounds(28, 52, 177, 33);
		contentPane.add(btnNewButton);
		
		JButton Excluir = new JButton("Excluir");
		Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresM();
			}
		});
		Excluir.setBounds(28, 114, 177, 33);
		contentPane.add(Excluir);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(242, 22, 45, 13);
		contentPane.add(lblNewLabel);
		
		textCodigoM = new JTextField();
		textCodigoM.setEnabled(false);
		textCodigoM.setBounds(283, 19, 54, 19);
		contentPane.add(textCodigoM);
		textCodigoM.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("carregar Campos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_1.setBounds(538, 12, 111, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.setBounds(28, 180, 177, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(564, 278, 85, 21);
		contentPane.add(btnVoltar);
	}
	
	public void listarValoresM() {
		try {
			ControlMedico objmedico = new ControlMedico();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Medico> lista = objmedico.PesquisarMedico();
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdmedico(),
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
	private void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigoM.setText(table.getModel().getValueAt(setar, 0).toString());
	}
	
	
	private void excluir() {
		int id_medico;
		
		id_medico = Integer.parseInt(textCodigoM.getText());
		
		Medico objmedico = new Medico();
		objmedico.setIdmedico(id_medico);
		
		ControlMedico objcontrolmedico = new ControlMedico();
		objcontrolmedico.excluirMedico(objmedico);
		
		
	}
}

