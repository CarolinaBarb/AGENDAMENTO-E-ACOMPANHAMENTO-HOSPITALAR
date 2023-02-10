package view;

import java.awt.EventQueue;
import java.lang.annotation.Target;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Color;

import control.*;
import model.Paciente;
import model.Paciente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MostrarPacientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textCpf;
	private JTextField textAltura;
	private JTextField textPeso;
	private JTextField textSexo;
	private JTextField textObs;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JTextField textDataNascimento;
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
		setBounds(100, 100, 1034, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		model = new DefaultTableModel();
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 82, 636, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Idade", "Data de nascimento", "CPF", "Altura", "Peso", "Sexo", "Email", "Observa\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(54);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		table.getColumnModel().getColumn(4).setPreferredWidth(46);
		table.getColumnModel().getColumn(5).setPreferredWidth(69);
		table.getColumnModel().getColumn(6).setPreferredWidth(49);
		table.getColumnModel().getColumn(9).setPreferredWidth(104);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -18, 1022, 53);
		panel.setBackground(new Color(9, 69, 108));
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, email, senha, sexo, observacao, cpf, idade, dataNascimento;
				String  altura, peso;
				
				nome = textNome.getText();
				email = textEmail.getText();
				senha = passwordField.getText();
				sexo = textSexo.getText();
				altura =textAltura.getText();
				peso = textPeso.getText();
				observacao = textObs.getText();
				cpf = textCpf.getText();
				dataNascimento = textDataNascimento.getText();
				idade = textIdade.getText();
				
				
				Paciente pacientes = new Paciente();
				pacientes.setNome(nome);
				pacientes.setEmail(email);
				pacientes.setSenha(senha);
				pacientes.setSexo(sexo);
				pacientes.setDataNascimento(dataNascimento);
				pacientes.setAltura(altura);
				pacientes.setPeso(peso);
				pacientes.setObservacao(observacao);
				pacientes.setCpf(cpf);
				pacientes.setIdade(idade);
				
			
				ControlAdministrador pacientecontrol = new ControlAdministrador();
				pacientecontrol.cadastrarPaciente(pacientes);
				
				listarValores();
				limpar();
			}
			
		});
		btnNewButton.setBounds(20, 284, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("excluir");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValores();
			}
		});
		btnNewButton_1.setBounds(126, 284, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Carregar campos");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(9, 69, 108));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_2.setBounds(889, 49, 133, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setForeground(new Color(9, 69, 108));
		lblCodigo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblCodigo.setBounds(386, 59, 45, 13);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(255, 255, 255));
		textCodigo.setEnabled(false);
		textCodigo.setBounds(436, 59, 70, 13);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton Editar = new JButton("Editar");
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(9, 69, 108));
		Editar.setFont(new Font("Verdana", Font.PLAIN, 10));
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValores();
				limpar();
			}
		});
		Editar.setBounds(234, 284, 85, 21);
		contentPane.add(Editar);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_3.setBackground(new Color(9, 69, 108));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(937, 284, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(9, 69, 108));
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNome.setBounds(20, 65, 45, 13);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(61, 62, 272, 13);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblIdade.setForeground(new Color(9, 69, 108));
		lblIdade.setBounds(20, 88, 45, 13);
		contentPane.add(lblIdade);
		
		textIdade = new JTextField();
		textIdade.setBounds(61, 85, 61, 13);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(9, 69, 108));
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblCpf.setBounds(150, 134, 45, 13);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(194, 131, 139, 16);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblAltura.setForeground(new Color(9, 69, 108));
		lblAltura.setBounds(20, 111, 45, 13);
		contentPane.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setBounds(61, 108, 61, 13);
		contentPane.add(textAltura);
		textAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setForeground(new Color(9, 69, 108));
		lblPeso.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblPeso.setBounds(132, 111, 95, 13);
		contentPane.add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setBounds(194, 108, 139, 16);
		contentPane.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(9, 69, 108));
		lblSexo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblSexo.setBounds(20, 134, 45, 13);
		contentPane.add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(61, 131, 79, 16);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblObservacao = new JLabel("Observação: ");
		lblObservacao.setForeground(new Color(9, 69, 108));
		lblObservacao.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblObservacao.setBounds(20, 157, 85, 13);
		contentPane.add(lblObservacao);
		
		textObs = new JTextField();
		textObs.setBounds(93, 154, 240, 61);
		contentPane.add(textObs);
		textObs.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(9, 69, 108));
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblEmail.setBounds(20, 229, 45, 13);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(61, 225, 272, 13);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(9, 69, 108));
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblSenha.setBounds(20, 252, 45, 13);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(61, 252, 272, 13);
		contentPane.add(passwordField);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setForeground(new Color(9, 69, 108));
		lblDataNascimento.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblDataNascimento.setBounds(132, 89, 121, 13);
		contentPane.add(lblDataNascimento);
		
		textDataNascimento = new JTextField();
		textDataNascimento.setBounds(263, 86, 70, 13);
		contentPane.add(textDataNascimento);
		textDataNascimento.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnLimpar.setBackground(new Color(9, 69, 108));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(785, 49, 85, 21);
		contentPane.add(btnLimpar);
		
		
		
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
						lista.get(num).getIdade(),
						lista.get(num).getDataNascimento(),
						lista.get(num).getCpf(),
						lista.get(num).getAltura(),
						lista.get(num).getPeso(),
						lista.get(num).getSexo(),
						lista.get(num).getEmail(),
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
		textNome.setText(table.getModel().getValueAt(setar, 1).toString());
		textIdade.setText(table.getModel().getValueAt(setar, 2).toString());
		textDataNascimento.setText(table.getModel().getValueAt(setar, 3).toString());
		textCpf.setText(table.getModel().getValueAt(setar, 4).toString());
		textAltura.setText(table.getModel().getValueAt(setar, 5).toString());
		textPeso.setText(table.getModel().getValueAt(setar, 6).toString());
		textSexo.setText(table.getModel().getValueAt(setar, 7).toString());
		textEmail.setText(table.getModel().getValueAt(setar, 8).toString());
		textObs.setText(table.getModel().getValueAt(setar, 9).toString());
		
	}
	private void excluir() {
		int id_paciente;
		
		id_paciente = Integer.parseInt(textCodigo.getText());
		Paciente objpaciente = new Paciente();
		objpaciente.setIdpaciente(id_paciente);
		
		ControlAdministrador objcontrolpaciente = new ControlAdministrador();
		objcontrolpaciente.excluirPaciente(objpaciente);
	}
	private void limpar() {
		textCodigo.setText("");
		textNome.setText("");
		textIdade.setText("");
		textDataNascimento.setText("");
		textCpf.setText("");
		textAltura.setText("");
		textPeso.setText("");
		textSexo.setText("");
		textEmail.setText("");
		textObs.setText("");
		
	}
	private void editar() {
		int idpaciente;
		String nome, idade, DataNascimento, Cpf, Altura, peso, sexo, email, obs, senha ;
		
		idpaciente = Integer.parseInt(textCodigo.getText());
		nome = textNome.getText();
		email = textEmail.getText();
		DataNascimento = textDataNascimento.getText();
		Cpf = textCpf.getText();
		Altura = textAltura.getText();
		peso = textPeso.getText();
		sexo = textSexo.getText();
		obs = textObs.getText();
		senha = passwordField.getText();
		idade = textIdade.getText();
		
		
		Paciente objeditarPaciente = new Paciente();
		objeditarPaciente.setIdpaciente(idpaciente);
		objeditarPaciente.setNome(nome);
		objeditarPaciente.setEmail(email);
		objeditarPaciente.setDataNascimento(DataNascimento);
		objeditarPaciente.setCpf(Cpf);
		objeditarPaciente.setAltura(Altura);
		objeditarPaciente.setPeso(peso);
		objeditarPaciente.setSexo(sexo);
		objeditarPaciente.setObservacao(obs);
		objeditarPaciente.setSenha(senha);
		objeditarPaciente.setIdade(idade);
		
		
		ControlAdministrador objcontrolPaciente = new ControlAdministrador();
		objcontrolPaciente.editarPaciente(objeditarPaciente);
	}
}
