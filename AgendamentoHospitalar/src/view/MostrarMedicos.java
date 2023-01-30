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
import java.awt.Font;
import javax.swing.JPasswordField;

public class MostrarMedicos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textCodigoM;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCrm;
	private JTextField textEspecialidade;
	private JPasswordField passwordField;

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
		setBounds(100, 100, 776, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 202, 333, -146);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(274, 55, 478, 111);
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
		
		JButton btnCadastro = new JButton("Cadastrar novo");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, email, crm, especialidade, senha;
				
				nome = textNome.getText();
				email = textEmail.getText();
				crm = textCrm.getText();
				especialidade = textEspecialidade.getText();
				senha = passwordField.getText();
				
				Medico objMedico = new Medico();
				objMedico.setNome(nome);
				objMedico.setEmail(email);
				objMedico.setCrm(crm);
				objMedico.setEspecialidade(especialidade);
				objMedico.setSenha(senha);
				
				ControlMedico objcontrolMedico = new ControlMedico();
				objcontrolMedico.cadastrar(objMedico);
				
				listarValoresM();
				limpar();
			}

			
		});
		btnCadastro.setBounds(10, 179, 122, 19);
		contentPane.add(btnCadastro);
		
		JButton Excluir = new JButton("Excluir");
		Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresM();
			}
		});
		Excluir.setBounds(142, 179, 122, 19);
		contentPane.add(Excluir);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(274, 32, 45, 13);
		contentPane.add(lblNewLabel);
		
		textCodigoM = new JTextField();
		textCodigoM.setEnabled(false);
		textCodigoM.setBounds(329, 29, 54, 19);
		contentPane.add(textCodigoM);
		textCodigoM.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("carregar Campos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_1.setBounds(641, 26, 111, 19);
		contentPane.add(btnNewButton_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValoresM();
				limpar();
			}
		});
		btnEditar.setBounds(274, 179, 122, 19);
		contentPane.add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(667, 178, 85, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(23, 30, 45, 13);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(70, 29, 194, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(23, 60, 45, 13);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(70, 55, 194, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCrm = new JLabel("Crm");
		lblCrm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCrm.setBounds(23, 83, 45, 13);
		contentPane.add(lblCrm);
		
		textCrm = new JTextField();
		textCrm.setBounds(70, 83, 96, 19);
		contentPane.add(textCrm);
		textCrm.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEspecialidade.setBounds(23, 106, 109, 13);
		contentPane.add(lblEspecialidade);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setBounds(119, 105, 144, 19);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(548, 26, 85, 21);
		contentPane.add(btnLimpar);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(23, 129, 45, 13);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 129, 144, 19);
		contentPane.add(passwordField);
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
		textNome.setText(table.getModel().getValueAt(setar, 1).toString());
		textEmail.setText(table.getModel().getValueAt(setar, 2).toString());
		textCrm.setText(table.getModel().getValueAt(setar, 3).toString());
		textEspecialidade.setText(table.getModel().getValueAt(setar, 4).toString());
		
	}
	private void limpar() {
		textCodigoM.setText("");
		textNome.setText("");
		textEmail.setText("");
		textCrm.setText("");
		textEspecialidade.setText("");
		
	}
	
	private void excluir() {
		int id_medico;
		
		id_medico = Integer.parseInt(textCodigoM.getText());
		
		Medico objmedico = new Medico();
		objmedico.setIdmedico(id_medico);
		
		ControlMedico objcontrolmedico = new ControlMedico();
		objcontrolmedico.excluirMedico(objmedico);
		
		
	}
	private void editar() {
		int idmedico;
		String nome, email, crm, especialidade, senha;
		
		idmedico = Integer.parseInt(textCodigoM.getText());
		nome = textNome.getText();
		email = textEmail.getText();
		crm = textCrm.getText();
		especialidade = textEspecialidade.getText();
		senha = passwordField.getText();
		
		
		Medico objeditarMedico = new Medico();
		objeditarMedico.setIdmedico(idmedico);
		objeditarMedico.setNome(nome);
		objeditarMedico.setEmail(email);
		objeditarMedico.setCrm(crm);
		objeditarMedico.setEspecialidade(especialidade);
		objeditarMedico.setSenha(senha);
		
		ControlMedico objcontrolMedico = new ControlMedico();
		objcontrolMedico.editar(objeditarMedico);
	}
}

