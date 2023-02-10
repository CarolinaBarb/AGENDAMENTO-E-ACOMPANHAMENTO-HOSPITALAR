package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

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
import control.ControlFuncionario;
import control.ControlPaciente;
import control.ControlReceitas;
import model.Consulta;
import model.Paciente;
import model.Receita;
import model.Recibo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TelaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTable table;
	private JTextField textMedico;
	private JTextField textEspecialidade;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textValor;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Pacientelbl = new JLabel("Paciente: ");
		Pacientelbl.setFont(new Font("Verdana", Font.PLAIN, 10));
		Pacientelbl.setForeground(new Color(9, 69, 108));
		Pacientelbl.setBounds(10, 10, 73, 13);
		contentPane.add(Pacientelbl);
		
		textNome = new JTextField();
		textNome.setEnabled(false);
		textNome.setBounds(63, 7, 530, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSelecionar = new JLabel("Selecionar Consultas:");
		lblSelecionar.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblSelecionar.setForeground(new Color(9, 69, 108));
		lblSelecionar.setBounds(10, 67, 189, 13);
		contentPane.add(lblSelecionar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 583, 90);
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
				"Nome", "Email", "Medico", "Especialidade", "Data", "Hora", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Médico:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setBounds(10, 190, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textMedico = new JTextField();
		textMedico.setEnabled(false);
		textMedico.setBounds(8, 206, 96, 19);
		contentPane.add(textMedico);
		textMedico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidade:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 239, 82, 20);
		contentPane.add(lblNewLabel_2);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setEnabled(false);
		textEspecialidade.setBounds(8, 262, 96, 19);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setBounds(124, 190, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textData = new JTextField();
		textData.setEnabled(false);
		textData.setBounds(124, 206, 96, 19);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setBounds(134, 243, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textHora = new JTextField();
		textHora.setEnabled(false);
		textHora.setBounds(133, 262, 96, 19);
		contentPane.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor:");
		lblNewLabel_5.setForeground(new Color(9, 69, 108));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(250, 190, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textValor = new JTextField();
		textValor.setEnabled(false);
		textValor.setBounds(247, 206, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JButton btnNewButton = new JButton("Conferir Receitas");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 String usuario;
						
						usuario = LoginPaciente.inserirEmail.getText();
						
						Receita objreceita = new Receita();
						objreceita.setEmail(usuario);
						
						ControlReceitas objcontrolreceita = new ControlReceitas();
						ResultSet rs = objcontrolreceita.autenticacaoReceita(objreceita);
					if(rs.next()) {
						   ReceitaPaciente rp = new ReceitaPaciente();
						   rp.ListarValoresReceita(usuario);
						   rp.setVisible(true);
					       dispose();
						   
					   }
					   else {
						   //enviar msg dizendo incorreto
						   JOptionPane.showMessageDialog(null, "email invalido");
					   }
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null,"FRMTelaPacienteView" +erro);
				}
			
		}});
		btnNewButton.setBounds(628, 93, 153, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Conferir Prontuário");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String usuario;
						
						usuario = LoginPaciente.inserirEmail.getText();
						
						Paciente objpaciente = new Paciente();
						objpaciente.setEmail(usuario);
						
						Consulta objconsulta = new Consulta();
						objconsulta.setEmail(usuario);
						
						ControlPaciente objcontrolpaciente = new ControlPaciente();
						ControlConsulta objcontrolconsulta = new ControlConsulta();
						ResultSet rs = objcontrolpaciente.autenticacaoAcessoProntuario(objpaciente);objcontrolconsulta.autenticacaoAcessoProntuarioC(objconsulta);
					if(rs.next()) {
						Prontuario pt = new Prontuario();
						pt.listarValoresProntuarioPaciente(usuario);
						pt.listarValoresProntuarioConsulta(usuario);
						pt.setVisible(true);
						dispose();
						   
					   }
					   else {
						   //enviar msg dizendo incorreto
						   JOptionPane.showMessageDialog(null, "email invalido");
					   }
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null,"FRMTelaPacienteView" +erro);
				}
		}});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.setBounds(628, 142, 152, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.setBackground(new Color(9, 69, 108));
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
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(9, 69, 108));
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnNewButton_3.setBounds(679, 48, 102, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lbltextEmail = new JLabel("Email:");
		lbltextEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbltextEmail.setForeground(new Color(9, 69, 108));
		lbltextEmail.setBounds(10, 33, 45, 13);
		contentPane.add(lbltextEmail);
		
		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setBounds(63, 33, 530, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Recibos de Pagamentos");
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {	
				String usuario;
				usuario = LoginPaciente.inserirEmail.getText();
				
				Recibo objrecibo = new Recibo();
				objrecibo.setEmail_Paciente(usuario);
				
				ControlFuncionario objcontrolrecibo = new ControlFuncionario();
				ResultSet rs = objcontrolrecibo.autenticacaoRecibo(objrecibo);
			if(rs.next()) {
				   Recibos rp = new Recibos();
				   rp.listarValores(usuario);;
				   rp.setVisible(true);
			       dispose();}
				   
			   else {
				   //enviar msg dizendo incorreto
				   JOptionPane.showMessageDialog(null, "email invalido");
			   }
		} catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"FRMTelaPacienteView" +erro);
		}
	
			}});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(55, 72, 121));
		btnNewButton_4.setBounds(629, 188, 152, 21);
		contentPane.add(btnNewButton_4);
		
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
	}
	
	public JTextField getInserirEmail() {
		return textEmail;
	}
}
