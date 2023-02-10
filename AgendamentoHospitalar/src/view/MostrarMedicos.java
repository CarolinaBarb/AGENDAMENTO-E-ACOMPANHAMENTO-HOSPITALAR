package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlAdministrador;
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
import java.awt.Color;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCadastro.setBackground(new Color(9, 61, 108));
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
				
				ControlAdministrador objcontrolMedico = new ControlAdministrador();
				objcontrolMedico.cadastrarMedico(objMedico);
				
				listarValoresM();
				limpar();
			}

			
		});
		btnCadastro.setBounds(10, 179, 122, 19);
		contentPane.add(btnCadastro);
		
		JButton Excluir = new JButton("Excluir");
		Excluir.setForeground(new Color(255, 255, 255));
		Excluir.setFont(new Font("Verdana", Font.PLAIN, 10));
		Excluir.setBackground(new Color(9, 61, 108));
		Excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValoresM();
			}
		});
		Excluir.setBounds(142, 179, 122, 19);
		contentPane.add(Excluir);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setForeground(new Color(9, 61, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(274, 32, 58, 13);
		contentPane.add(lblNewLabel);
		
		textCodigoM = new JTextField();
		textCodigoM.setBackground(new Color(255, 255, 255));
		textCodigoM.setEnabled(false);
		textCodigoM.setBounds(330, 30, 66, 19);
		contentPane.add(textCodigoM);
		textCodigoM.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("carregar Campos");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(9, 61, 108));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_1.setBounds(628, 24, 124, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnEditar.setBackground(new Color(9, 61, 108));
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
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.setBackground(new Color(9, 61, 108));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(667, 178, 85, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(9, 61, 108));
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNome.setBounds(23, 30, 45, 13);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(70, 29, 194, 16);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(9, 61, 108));
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEmail.setBounds(23, 60, 45, 13);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(70, 55, 194, 18);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setForeground(new Color(9, 61, 108));
		lblCrm.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCrm.setBounds(23, 83, 45, 13);
		contentPane.add(lblCrm);
		
		textCrm = new JTextField();
		textCrm.setBounds(70, 81, 194, 15);
		contentPane.add(textCrm);
		textCrm.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setForeground(new Color(9, 61, 108));
		lblEspecialidade.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEspecialidade.setBounds(23, 106, 109, 13);
		contentPane.add(lblEspecialidade);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setBounds(119, 105, 144, 14);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnLimpar.setBackground(new Color(9, 61, 108));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(534, 24, 85, 21);
		contentPane.add(btnLimpar);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(9, 61, 108));
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSenha.setBounds(23, 129, 45, 13);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 129, 193, 13);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 61, 108));
		panel.setBounds(0, 0, 762, 14);
		contentPane.add(panel);
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
		
		ControlAdministrador objcontrolmedico = new ControlAdministrador();
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
		
		ControlAdministrador objcontrolMedico = new ControlAdministrador();
		objcontrolMedico.editar(objeditarMedico);
	}
}

