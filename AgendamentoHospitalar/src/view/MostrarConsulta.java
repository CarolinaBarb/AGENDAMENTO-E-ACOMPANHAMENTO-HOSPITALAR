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

import control.ControlAdministrador;
import control.ControlConsulta;
import control.ControlConsulta;
import model.Consulta;
import model.Consulta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MostrarConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textNomeMedico;
	private JTextField textEspecialidade;
	private JTextField textData;
	private JTextField textHorario;
	private JTextField textValor;
	private JTextField textCodigo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarConsulta frame = new MostrarConsulta();
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
	public MostrarConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setForeground(new Color(9, 61, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 51, 58, 13);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(78, 48, 296, 16);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Médico:");
		lblNewLabel_1.setForeground(new Color(9, 61, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 74, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textNomeMedico = new JTextField();
		textNomeMedico.setBounds(78, 71, 296, 16);
		contentPane.add(textNomeMedico);
		textNomeMedico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidade:");
		lblNewLabel_2.setForeground(new Color(9, 61, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 97, 86, 13);
		contentPane.add(lblNewLabel_2);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setBounds(99, 94, 275, 16);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data:");
		lblNewLabel_3.setForeground(new Color(9, 61, 108));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(10, 120, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textData = new JTextField();
		textData.setBounds(65, 117, 96, 16);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Horário:");
		lblNewLabel_4.setForeground(new Color(9, 61, 108));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(10, 143, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textHorario = new JTextField();
		textHorario.setBounds(65, 140, 96, 16);
		contentPane.add(textHorario);
		textHorario.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor:");
		lblNewLabel_5.setForeground(new Color(9, 61, 108));
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(10, 166, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textValor = new JTextField();
		textValor.setBounds(65, 163, 96, 16);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Código:");
		lblNewLabel_6.setForeground(new Color(9, 61, 108));
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(400, 48, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(448, 48, 66, 16);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 67, 467, 128);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Paciente", "Medico", "Especialidade", "Horario", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBackground(new Color(9, 61, 108));
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
	
			}
		});
		btnSelecionar.setBounds(763, 40, 104, 21);
		contentPane.add(btnSelecionar);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setBackground(new Color(9, 61, 108));
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(668, 40, 85, 21);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(9, 61, 108));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdmin ta = new TelaAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(782, 204, 85, 21);
		contentPane.add(btnVoltar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnExcluir.setBackground(new Color(9, 61, 108));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(10, 204, 85, 21);
		contentPane.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(9, 61, 108));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				listarValores();
			}
		});
		btnEditar.setBounds(110, 204, 85, 21);
		contentPane.add(btnEditar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 61, 108));
		panel.setBounds(0, 0, 879, 26);
		contentPane.add(panel);
	}
	
	public void listarValores() {
		try {
			ControlConsulta objcontrolconsulta = new ControlConsulta();
			DefaultTableModel  model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Consulta> lista1 = objcontrolconsulta.PesquisarConsulta();
			for(int num = 0;num < lista1.size();num++ ) {
				model.addRow(new Object[] {
					lista1.get(num).getID(),
					lista1.get(num).getIdPaciente(),
					lista1.get(num).getIdMedico(),
					lista1.get(num).getEspecialidade(),
					lista1.get(num).getHorario(),
					lista1.get(num).getValor(),
					lista1.get(num).getData(),
				});
			}
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores Consulta" + erro);
		}
		
	}
	private void CarregarCampos() {
		int setar = table.getSelectedRow();
		
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
		textNome.setText(table.getModel().getValueAt(setar, 1).toString());
		textNomeMedico.setText(table.getModel().getValueAt(setar, 2).toString());
		textEspecialidade.setText(table.getModel().getValueAt(setar, 3).toString());
		textHorario.setText(table.getModel().getValueAt(setar, 4).toString());
		textValor.setText(table.getModel().getValueAt(setar, 5).toString());
		textData.setText(table.getModel().getValueAt(setar, 6).toString());
	}
	private void limpar() {
		textCodigo.setText("");
		textNome.setText("");
		textNomeMedico.setText("");
		textEspecialidade.setText("");
		textHorario.setText("");
		textValor.setText("");
		textData.setText("");
	}
	private void editar() {
		int idconsulta;
		String nome, nome_medico, especialidade, horario, valor, data;
		
		idconsulta = Integer.parseInt(textCodigo.getText());
		nome = textNome.getText();
		nome_medico = textNomeMedico.getText();
		especialidade = textEspecialidade.getText();
		horario = textHorario.getText();
		valor = textValor.getText();
		data = textData.getText();
		
		Consulta objeditarconsulta = new Consulta();
		objeditarconsulta.setID(idconsulta);
		objeditarconsulta.setIdPaciente(nome);
		objeditarconsulta.setIdMedico(nome_medico);
		objeditarconsulta.setEspecialidade(especialidade);
		objeditarconsulta.setHorario(horario);
		objeditarconsulta.setValor(valor);
		objeditarconsulta.setData(data);
		
		ControlAdministrador objControlConsulta = new ControlAdministrador();
		objControlConsulta.editarConsulta(objeditarconsulta);
	}
	private void excluir() {
		int idConsulta;
		
		idConsulta = Integer.parseInt(textCodigo.getText());
		
		Consulta objconsulta = new Consulta();
		objconsulta.setID(idConsulta);
		
		ControlAdministrador objcontrolConsulta = new ControlAdministrador();
		objcontrolConsulta.excluirconsultas(objconsulta);;
		
		
	}
	
}
