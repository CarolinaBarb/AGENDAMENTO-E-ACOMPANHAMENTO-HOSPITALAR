package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.ControlAdministrador;
import control.ControlConsulta;
import control.ControlFuncionario;
import model.Consulta;
import model.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class MostrarFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDataNascimento;
	private JTextField textCPF;
	private JTextField textDataadmissao;
	private JTable table;
	private JTextField textContato;
	private JTextField textFuncao;
	private JTextField textCodigo;
	private JTextField textSexo;
	private JTextField textEmail;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarFuncionarios frame = new MostrarFuncionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MostrarFuncionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 42, 192, 13);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(54, 41, 195, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblData_nascimento = new JLabel("Data de Nascimento:");
		lblData_nascimento.setForeground(new Color(9, 69, 108));
		lblData_nascimento.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblData_nascimento.setBounds(8, 120, 170, 13);
		contentPane.add(lblData_nascimento);
		
		textDataNascimento = new JTextField();
		textDataNascimento.setBounds(146, 119, 103, 19);
		contentPane.add(textDataNascimento);
		textDataNascimento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(11, 64, 45, 19);
		contentPane.add(lblNewLabel_1);
		
		textCPF = new JTextField();
		textCPF.setBounds(55, 65, 194, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de admissão:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(8, 93, 156, 13);
		contentPane.add(lblNewLabel_2);
		
		textDataadmissao = new JTextField();
		textDataadmissao.setBounds(136, 93, 113, 19);
		contentPane.add(textDataadmissao);
		textDataadmissao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 53, 740, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data de nascimento", "Data de admissao", "Funcao", "email", "Sexo", "Contato"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(99);
		table.getColumnModel().getColumn(6).setPreferredWidth(67);
		scrollPane.setViewportView(table);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setForeground(new Color(9, 69, 108));
		lblContato.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblContato.setBounds(8, 173, 119, 13);
		contentPane.add(lblContato);
		
		textContato = new JTextField();
		textContato.setBounds(75, 168, 174, 19);
		contentPane.add(textContato);
		textContato.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Função:");
		lblFuncao.setForeground(new Color(9, 69, 108));
		lblFuncao.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFuncao.setBounds(7, 197, 67, 13);
		contentPane.add(lblFuncao);
		
		textFuncao = new JTextField();
		textFuncao.setBounds(74, 195, 175, 19);
		contentPane.add(textFuncao);
		textFuncao.setColumns(10);
		
		JLabel Codigo = new JLabel("Código:");
		Codigo.setForeground(new Color(9, 69, 108));
		Codigo.setFont(new Font("Verdana", Font.PLAIN, 12));
		Codigo.setBounds(264, 20, 84, 24);
		contentPane.add(Codigo);
		
		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(255, 255, 255));
		textCodigo.setEnabled(false);
		textCodigo.setBounds(321, 24, 96, 19);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnCarregarCampos = new JButton("CarregarCampos");
		btnCarregarCampos.setForeground(new Color(255, 255, 255));
		btnCarregarCampos.setBackground(new Color(9, 69, 108));
		btnCarregarCampos.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
			
		});
		btnCarregarCampos.setBounds(853, 16, 152, 21);
		contentPane.add(btnCarregarCampos);
		
		JButton btnCadastar = new JButton("Cadastrar");
		btnCadastar.setForeground(new Color(255, 255, 255));
		btnCadastar.setBackground(new Color(9, 69, 108));
		btnCadastar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, cpf, data_nascimento, email, senha, data_admissao, funcao, contato, sexo;
				
				nome = textNome.getText();
				cpf = textCPF.getText();
				data_nascimento = textDataNascimento.getText();
				email = textEmail.getText();
				senha = passwordField.getText();
				data_admissao = textDataadmissao.getText();
				funcao = textFuncao.getText();
				contato = textContato.getText();
				sexo = textSexo.getText();
			
				
				Funcionario objFuncionario = new Funcionario();
				objFuncionario.setContato(contato);
				objFuncionario.setCpf(cpf);
				objFuncionario.setData_admissao(data_admissao);
				objFuncionario.setDataNascimento(data_nascimento);
				objFuncionario.setFuncao(funcao);
				objFuncionario.setNome(nome);
				objFuncionario.setEmail(email);
				objFuncionario.setSenha(senha);
				objFuncionario.setSexo(sexo);
				
				ControlAdministrador objcontrolfun = new ControlAdministrador();
				objcontrolfun.CadastrarFuncionario(objFuncionario);
				
				listarValores();
				limpar(); 
				
			}
		});
		btnCadastar.setBounds(213, 305, 171, 21);
		contentPane.add(btnCadastar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnExcluir.setBackground(new Color(9, 69, 108));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listarValores();
				limpar();
			}
		});
		btnExcluir.setBounds(418, 305, 170, 21);
		contentPane.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(9, 69, 108));
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValores();
				limpar();
			}
		});
		btnEditar.setBounds(634, 305, 169, 21);
		contentPane.add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.setBackground(new Color(9, 69, 108));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(920, 301, 85, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(9, 69, 108));
		lblSexo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSexo.setBounds(9, 146, 45, 13);
		contentPane.add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(47, 143, 202, 19);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(9, 69, 108));
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEmail.setBounds(10, 220, 45, 13);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(54, 220, 195, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(9, 69, 108));
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSenha.setBounds(10, 249, 45, 13);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(54, 246, 195, 19);
		contentPane.add(passwordField);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnLimpar.setBackground(new Color(9, 69, 108));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 305, 170, 21);
		contentPane.add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 1009, 13);
		contentPane.add(panel);
	}
	
	public void listarValores() {
		try {
			ControlFuncionario objcontrolsecre = new ControlFuncionario();
			
			DefaultTableModel Model = (DefaultTableModel) table.getModel();
			Model.setNumRows(0);
			
			ArrayList<Funcionario> Lista = objcontrolsecre.PesquisarFuncionario();
			
			for (int num = 0; num < Lista.size(); num ++) {
				Model.addRow(new Object[] {
						Lista.get(num).getIdfuncionario(),
						Lista.get(num).getNome(),
						Lista.get(num).getCpf(),
						Lista.get(num).getDataNascimento(),
						Lista.get(num).getData_admissao(),
						Lista.get(num).getFuncao(),
						Lista.get(num).getEmail(),
						Lista.get(num).getSexo(),
						Lista.get(num).getContato(),
				});
				
				
			}
		}catch(Exception erro) {
			
			JOptionPane.showMessageDialog(null, " Listar valores View"+ erro);
			
			
		}
		
	}
	private void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
		textNome.setText(table.getModel().getValueAt(setar, 1).toString());
		textCPF.setText(table.getModel().getValueAt(setar, 2).toString());
		textDataNascimento.setText(table.getModel().getValueAt(setar, 3).toString());
		textDataadmissao.setText(table.getModel().getValueAt(setar, 4).toString());
		textFuncao.setText(table.getModel().getValueAt(setar, 5).toString());
		textEmail.setText(table.getModel().getValueAt(setar, 6).toString());
		textSexo.setText(table.getModel().getValueAt(setar, 7).toString());
		textContato.setText(table.getModel().getValueAt(setar, 8).toString());
	}
	
	private void excluir() {
		int id_funcionario;
		
		id_funcionario = Integer.parseInt(textCodigo.getText());
		
		Funcionario objsecretaria = new Funcionario();
		objsecretaria.setIdfuncionario(id_funcionario);
		
		ControlAdministrador objcontrolsecretaria = new ControlAdministrador();
		objcontrolsecretaria.excluirFuncionario(objsecretaria);
	}
	
	private void limpar() {
		textCodigo.setText("");
		textNome.setText("");
		textCPF.setText("");
		textDataNascimento.setText("");
		textDataadmissao.setText("");
		textFuncao.setText("");
		textEmail.setText("");
		textSexo.setText("");
		textContato.setText("");
		passwordField.setText("");
		
	}
	private void editar() {
		int idfuncionario;
		String nome, cpf, DataNascimento, Dataadmissao, Funcao, sexo, contato, senha,email;
		
		idfuncionario = Integer.parseInt(textCodigo.getText());
		nome = textNome.getText();
		cpf = textCPF.getText();
		DataNascimento = textDataNascimento.getText();
		Dataadmissao = textDataadmissao.getText();
		Funcao = textFuncao.getText();
		sexo = textSexo.getText();
		contato = textContato.getText();
		senha = passwordField.getText();
		email = textEmail.getText();
		
		Funcionario objeditarfuncionario = new Funcionario();
		objeditarfuncionario.setIdfuncionario(idfuncionario);
		objeditarfuncionario.setNome(nome);
		objeditarfuncionario.setCpf(cpf);
		objeditarfuncionario.setDataNascimento(DataNascimento);
		objeditarfuncionario.setData_admissao(Dataadmissao);;
		objeditarfuncionario.setFuncao(Funcao);;
		objeditarfuncionario.setSexo(sexo);
		objeditarfuncionario.setContato(contato);
		objeditarfuncionario.setSenha(senha);
		objeditarfuncionario.setEmail(email);;
		
		ControlAdministrador objcontrolfuncionario = new ControlAdministrador();
		objcontrolfuncionario.editarFuncionario(objeditarfuncionario);
		
	}
}
