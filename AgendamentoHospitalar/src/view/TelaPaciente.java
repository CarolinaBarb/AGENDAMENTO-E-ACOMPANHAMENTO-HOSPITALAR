package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlConsulta;
import model.Consulta;
import model.Receita;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTable table;
	private JTextField textMedico;
	private JTextField textEspecialidade;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textValor;
	private JTextField textDiagnostico;
	private JTextField textObs;
	public static JTextField textEmail;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		
		listarValoresPaciente(LoginPaciente.inserirEmail.getText());
		if(ControlConsulta.lista.isEmpty()){
	        
        }else{
        	textNome.setText(ControlConsulta.lista.get(0).getEmail());
            //System.out.println("vazio");
        }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Pacientelbl = new JLabel("Paciente: ");
		Pacientelbl.setBounds(10, 10, 73, 13);
		contentPane.add(Pacientelbl);
		
		textNome = new JTextField();
		textNome.setEnabled(false);
		textNome.setBounds(63, 7, 530, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSelecionar = new JLabel("Selecionar Consultas");
		lblSelecionar.setBounds(10, 57, 189, 13);
		contentPane.add(lblSelecionar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 583, 90);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nome", "Email", "Medico", "Especialidade", "Data", "Hora", "Valor", "Diagn\u00F3stico", "Observa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Medico");
		lblNewLabel_1.setBounds(12, 183, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textMedico = new JTextField();
		textMedico.setEnabled(false);
		textMedico.setBounds(8, 198, 96, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidade");
		lblNewLabel_2.setBounds(10, 222, 82, 20);
		contentPane.add(lblNewLabel_2);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setEnabled(false);
		textEspecialidade.setBounds(8, 245, 96, 19);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setBounds(127, 186, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textData = new JTextField();
		textData.setEnabled(false);
		textData.setBounds(122, 201, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Hora");
		lblNewLabel_4.setBounds(126, 229, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textHora = new JTextField();
		textHora.setEnabled(false);
		textHora.setBounds(120, 246, 96, 19);
		contentPane.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor");
		lblNewLabel_5.setBounds(237, 187, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textValor = new JTextField();
		textValor.setEnabled(false);
		textValor.setBounds(230, 203, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Diagnostico");
		lblNewLabel_6.setBounds(234, 231, 78, 13);
		contentPane.add(lblNewLabel_6);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setEnabled(false);
		textDiagnostico.setBounds(231, 248, 96, 19);
		contentPane.add(textDiagnostico);
		textDiagnostico.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Observação");
		lblNewLabel_7.setBounds(344, 187, 89, 13);
		contentPane.add(lblNewLabel_7);
		
		textObs = new JTextField();
		textObs.setEnabled(false);
		textObs.setBounds(344, 205, 249, 62);
		contentPane.add(textObs);
		textObs.setColumns(10);
		
		JButton btnNewButton = new JButton("Conferir Receitas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario;
					
				usuario = textEmail.getText();
				
				Receita objreceita = new Receita();
				objreceita.setEmail(usuario);
					
				ReceitaPaciente rp = new ReceitaPaciente();
				rp.ListarValoresReceita(usuario);
				rp.setVisible(true);
				dispose();
			
		}});
		btnNewButton.setBounds(628, 76, 153, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Conferir Prontuário");
		btnNewButton_1.setBounds(629, 107, 152, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(696, 289, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Selecionar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_3.setBounds(428, 57, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lbltextEmail = new JLabel("Email");
		lbltextEmail.setBounds(10, 33, 45, 13);
		contentPane.add(lbltextEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setBounds(63, 33, 530, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
	}
	
	


	public void listarValoresPaciente(String email) {
		try {
			ControlConsulta objpesquisarConsulta = new ControlConsulta();
			
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista = objpesquisarConsulta.PacienteConsulta(email);
			
			for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
						lista.get(num).getIdPaciente(),
						lista.get(num).getEmail(),
						lista.get(num).getIdMedico(),
						lista.get(num).getEspecialidade(),
						lista.get(num).getData(),
						lista.get(num).getHorario(),
						lista.get(num).getValor(),
						lista.get(num).getDiagnostico(),
						lista.get(num).getObs(),
						
				});
			}
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Listar Valores  Paciente View:" + erro);
			
		}
		
	}
	public void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textNome.setText(table.getModel().getValueAt(setar, 0).toString());
		textEmail.setText(table.getModel().getValueAt(setar, 1).toString());
		textMedico.setText(table.getModel().getValueAt(setar, 2).toString());
		textEspecialidade.setText(table.getModel().getValueAt(setar, 3).toString());
		textHora.setText(table.getModel().getValueAt(setar, 4).toString());
		textData.setText(table.getModel().getValueAt(setar, 5).toString());
		textValor.setText(table.getModel().getValueAt(setar, 6).toString());
		textDiagnostico.setText(table.getModel().getValueAt(setar, 7).toString());
		textObs.setText(table.getModel().getValueAt(setar, 8).toString());
	}
	
	public JTextField getInserirEmail() {
		return textEmail;
	}
}
